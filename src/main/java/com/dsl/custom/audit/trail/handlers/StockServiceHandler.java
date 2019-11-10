/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.custom.audit.trail.handlers;

import com.dsl.custom.audit.trail.aspects.Audited;
import com.dsl.custom.audit.trail.domain.StockEntity;
import com.dsl.custom.audit.trail.model.Stock;
import com.dsl.custom.audit.trail.repository.StockRepository;
import com.dsl.custom.audit.trail.services.StockService;
import com.dsl.custom.audit.trail.services.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class StockServiceHandler implements StockService
{
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> list()
    {
        return stockRepository.findAll().stream().map(this::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Stock search(Long id)
    {
        StockEntity entity = stockRepository.findById(id).orElse(null);
        if(Objects.nonNull(entity))
        {
            return fromEntity(entity);
        }
        return null;
    }

    @Override
    @Audited(value = "STOCK", target = AuditService.class)
    public Stock create(Stock stock)
    {
        StockEntity entity = new StockEntity();
        entity.setName(stock.getName());
        entity.setDescription(stock.getDescription());
        entity.setQuantity(stock.getQuantity());

        StockEntity created = stockRepository.save(entity);

        return fromEntity(created);
    }

    @Override
    public Stock update(Stock stock)
    {
        StockEntity entity = stockRepository.findById(stock.getId()).orElse(null);
        if(Objects.nonNull(entity))
        {
            entity.setId(stock.getId());
            entity.setName(stock.getName());
            entity.setDescription(stock.getDescription());
            entity.setQuantity(stock.getQuantity());

            StockEntity updated = stockRepository.save(entity);

            return fromEntity(updated);
        }
        return null;
    }

    @Override
    public void delete(Long id)
    {
        stockRepository.deleteById(id);
    }

    private Stock fromEntity(StockEntity entity)
    {
        Stock stock = new Stock();
        stock.setId(entity.getId());
        stock.setName(entity.getName());
        stock.setDescription(entity.getDescription());
        stock.setQuantity(entity.getQuantity());
        return stock;
    }
}

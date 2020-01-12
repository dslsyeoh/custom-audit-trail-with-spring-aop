/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.custom.audit.trail.controllers;

import com.dsl.custom.audit.trail.model.Stock;
import com.dsl.custom.audit.trail.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stocks")
public class StockController
{
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> list()
    {
        return stockService.list();
    }

    @GetMapping("/{id}")
    public Stock search(@PathVariable Long id)
    {
        return stockService.search(id);
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock)
    {
        return stockService.create(stock);
    }

    @PutMapping
    public Stock update(@RequestBody Stock stock)
    {
        return stockService.update(stock);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        stockService.delete(id);
    }

}

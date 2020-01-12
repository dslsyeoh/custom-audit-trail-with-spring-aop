/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.custom.audit.trail.services;

import com.dsl.custom.audit.trail.model.Stock;

import java.util.List;

public interface StockService
{
    List<Stock> list();

    Stock search(Long id);

    Stock create(Stock stock);

    Stock update(Stock stock);

    void delete(Long id);
}

/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.custom.audit.trail.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stocks")
public class StockEntity
{
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private int quantity;
}


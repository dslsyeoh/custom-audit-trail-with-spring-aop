/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.custom.audit.trail.model;

import lombok.Data;

@Data
public class Stock
{
    private Long id;
    private String name;
    private String description;
    private int quantity;
}

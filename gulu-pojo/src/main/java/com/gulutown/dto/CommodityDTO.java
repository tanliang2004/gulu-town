package com.gulutown.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommodityDTO {
    private Long id;
    private Long categoryId;
    private String productName;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String imageUrl;
    private Byte status;
    private Byte isRecommended;
    private Integer sales;
}

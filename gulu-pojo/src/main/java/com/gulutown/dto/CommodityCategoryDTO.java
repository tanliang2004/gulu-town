package com.gulutown.dto;

import lombok.Data;

@Data
public class CommodityCategoryDTO {
    /**
     * 商品分类id
     */
    private Long id;
    /**
     * 商品分类名
     */
    private String categoryName;
    /**
     * 商品分类排序（数字越小约靠前）
     */
    private int sortOrder;
    /**
     * 商品分类描述
     */
    private String description;

}

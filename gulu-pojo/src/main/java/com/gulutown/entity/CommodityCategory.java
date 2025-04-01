package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityCategory {
    /**
     * 商品分类ID
     */
    private Long id;
    /**
     * 商品分类名
     */
    private String categoryName;
    /**
     * 商品分类排序（数字越小约靠前）
     */
    private Integer sortOrder;
    /**
     * 商品分类描述
     */
    private String description;
    /**
     * 商品分类创建时间
     */
    private LocalDateTime createTime;


}

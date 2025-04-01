package com.gulutown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityInfo {
    /**
     * 商品唯一ID
     */
    private Long id;
    /**
     * 外键，关联商品分类表ID
     */
    private Long categoryId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品唯一编码
     */
    private String sku;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品库存
     */
    private Integer stock;
    /**
     * 商品详情描述
     */
    private String description;
    /**
     * 商品图片链接
     */
    private String imageUrl;
    /**
     * 状态（0-下架，1-上架，2-预售）
     */
    private Byte status;
    /**
     * 是否推荐（0-否，1-是）
     */
    private Byte isRecommended;
    /**
     * 销量（默认0）
     */
    private Integer sales;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
}

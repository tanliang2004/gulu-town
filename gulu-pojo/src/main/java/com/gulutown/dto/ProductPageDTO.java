package com.gulutown.dto;

import lombok.Data;

/**
 * 商品分页查询
 */
@Data
public class ProductPageDTO {

    private Integer page;
    private Integer pageSize;
    private String categoryName;
    private String productName;
    private Integer status;


}

package com.gulutown.service;

import com.gulutown.dto.ProductPageDTO;
import com.gulutown.result.PageResult;

public interface ProductService {

    /**
     * 分页查询商品
     * @param productPageDTO 分页数据
     * @return 返回数据
     */
    PageResult pageQuery(ProductPageDTO productPageDTO);
}

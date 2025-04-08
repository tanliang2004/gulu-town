package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.ProductPageDTO;
import com.gulutown.entity.CommodityInfo;
import com.gulutown.mapper.ProductMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 分页查询商品
     * @param productPageDTO 分页数据
     * @return 返回数据
     */
    public PageResult pageQuery(ProductPageDTO productPageDTO) {
        PageHelper.startPage(productPageDTO.getPage(),productPageDTO.getPageSize());
        Page<CommodityInfo> page = productMapper.selectByAll(productPageDTO);
        return new PageResult(
                page.getTotal(),
                page.getResult()
        );
    }
}

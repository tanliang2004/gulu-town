package com.gulutown.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.CommodityDTO;
import com.gulutown.dto.ProductPageDTO;
import com.gulutown.entity.CommodityInfo;
import com.gulutown.mapper.ProductMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.ProductService;
import com.gulutown.utils.CodeUtil;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CodeUtil codeUti;
    @Autowired
    private CodeUtil codeUtil;

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

    /**
     * 添加商品
     * @param commodityDTO 添加的具体数据
     */
    public void add(CommodityDTO commodityDTO) {
        CommodityInfo commodityInfo = new CommodityInfo();
        BeanUtils.copyProperties(commodityDTO,commodityInfo);
        commodityInfo.setSku(codeUtil.generate());
        commodityInfo.setCreateTime(LocalDateTime.now());
        commodityInfo.setUpdateTime(LocalDateTime.now());
        productMapper.insert(commodityInfo);
    }

    /**
     * 根据商品id查询商品
     * @param id 商品id
     * @return 返回数据
     */
    public CommodityInfo queryById(Long id) {
        return productMapper.selectById(id);
    }

    /**
     * 修改商品
     * @param commodityDTO 修改数据
     */
    public void edit(CommodityDTO commodityDTO) {
        CommodityInfo commodityInfo = new CommodityInfo();
        BeanUtils.copyProperties(commodityDTO,commodityInfo);
        commodityInfo.setUpdateTime(LocalDateTime.now());
        productMapper.update(commodityInfo);
    }

    /**
     * 根据id删除商品
     * @param id 商品id
     */
    public void remove(Long id) {
        productMapper.deleteById(id);
    }
}

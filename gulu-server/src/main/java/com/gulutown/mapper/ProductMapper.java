package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.dto.ProductPageDTO;
import com.gulutown.entity.CommodityInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    Page<CommodityInfo> selectByAll(ProductPageDTO productPageDTO);
}

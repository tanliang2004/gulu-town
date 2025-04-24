package com.gulutown.service;

import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.PetInfo;
import com.gulutown.result.PageResult;

import java.util.List;

public interface PetService {
    /**
     * 宠物信息分页查询
     * @param productSortPageDTO 分页数据
     * @return 返回数据
     */
    PageResult page(ProductSortPageDTO productSortPageDTO);

    /**
     * 根据用户id查询宠物信息
     * @param userId
     * @return
     */
    List<PetInfo> queryByUserId(Long userId);
}

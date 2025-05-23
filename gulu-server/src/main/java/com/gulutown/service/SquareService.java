package com.gulutown.service;

import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.result.PageResult;

public interface SquareService {
    /**
     * 社区帖子分页查询
     * @param productSortPageDTO 分页数据
     * @return 返回数据
     */
    PageResult page(ProductSortPageDTO productSortPageDTO);

    /**
     * 根据帖子id删除帖子
     * @param postId 帖子id
     */
    void remove(Long postId);
}

package com.gulutown.service;

import com.gulutown.dto.UsersPageDTO;
import com.gulutown.result.PageResult;

public interface PetReturnService {
    /**
     * 查询所有宠物回家帖子
     * @param usersPageDTO 宠物帖子
     * @return 返回数据
     */
    PageResult queryAll(UsersPageDTO usersPageDTO);

    /**
     * 根据宠物回家帖子删除帖子
     * @param postId 帖子id
     */
    void remove(Long postId);

    /**
     * 将帖子的宠物状态修改为已找到
     * @param postId 帖子id
     */
    void update(Long postId);
}

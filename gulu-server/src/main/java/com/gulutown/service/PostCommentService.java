package com.gulutown.service;

import com.gulutown.vo.PostCommentVO;

import java.util.List;

public interface PostCommentService {

    /**
     * 根据帖子id查询评论
     * @param postId 帖子id
     * @return 返回数据
     */
    List<PostCommentVO> queryComment(Long postId);
}

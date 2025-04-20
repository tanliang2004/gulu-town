package com.gulutown.service.impl;

import com.gulutown.mapper.PostCommentMapper;
import com.gulutown.service.PostCommentService;
import com.gulutown.vo.PostCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    private PostCommentMapper postCommentMapper;

    /**
     * 根据帖子id查询评论
     * @param postId 帖子id
     * @return 返回数据
     */
    public List<PostCommentVO> queryComment(Long postId) {
        return postCommentMapper.selectByPostId(postId);
    }
}

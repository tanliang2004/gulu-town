package com.gulutown.mapper;

import com.gulutown.vo.PostCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostCommentMapper {

    /**
     * 根据帖子id查询评论
     * @return 返回的评论数据
     */
    List<PostCommentVO> selectByPostId(Long postId);
}

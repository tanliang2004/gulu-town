package com.gulutown.service;

import com.gulutown.entity.KnowledgePost;

import java.util.List;

public interface KnowledgeService {
    /**
     * 获取全部文章
     * @return 返回数据
     */
    List<KnowledgePost> queryAll();

    /**
     * 根据id删除文章
     * @param postId 文章id
     */
    void remove(Long postId);

    /**
     * 新增文章
     * @param knowledgePost 文章内容
     */
    void add(KnowledgePost knowledgePost);
}

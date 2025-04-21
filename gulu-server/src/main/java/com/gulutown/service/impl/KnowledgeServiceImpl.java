package com.gulutown.service.impl;

import com.gulutown.entity.KnowledgePost;
import com.gulutown.mapper.KnowledgeMapper;
import com.gulutown.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    /**
     * 获取全部文章
     * @return 返回数据
     */
    public List<KnowledgePost> queryAll() {
        return knowledgeMapper.selectAll();
    }

    /**
     * 根据id删除文章
     * @param postId 文章id
     */
    public void remove(Long postId) {
        knowledgeMapper.deleteById(postId);
    }

    /**
     * 新增文章
     * @param knowledgePost 文章内容
     */
    public void add(KnowledgePost knowledgePost) {
        knowledgePost.setCreateTime(LocalDateTime.now());
        knowledgeMapper.insert(knowledgePost);
    }
}

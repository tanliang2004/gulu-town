package com.gulutown.controller.community;

import com.gulutown.entity.KnowledgePost;
import com.gulutown.result.Result;
import com.gulutown.service.KnowledgeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 宠物科普（知识帖子）
 */
@RestController
@RequestMapping("/community/Knowledge")
@Slf4j
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    /**
     * 获取全部文章
     * @return 返回数据
     */
    @GetMapping
    public Result<List<KnowledgePost>> queryAll() {
        log.info("获取全部文章");
        List<KnowledgePost> knowledgePosts = knowledgeService.queryAll();
        return Result.success(knowledgePosts);
    }

    /**
     * 根据id删除文章
     * @param postId 文章id
     * @return 响应
     */
    @DeleteMapping("/{postId}")
    public Result<Object> remove(@PathVariable Long postId) {
        log.info("根据id删除文章,{}",postId);
        knowledgeService.remove(postId);
        return Result.success();
    }

    /**
     * 新增文章
     * @param knowledgePost 文章内容
     * @return 响应
     */
    @PostMapping
    public Result<Object> add(@RequestBody KnowledgePost knowledgePost) {
        knowledgeService.add(knowledgePost);
        return Result.success();
    }

}

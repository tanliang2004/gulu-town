package com.gulutown.controller.community;

import com.gulutown.dto.UsersPageDTO;
import com.gulutown.entity.MissingPetPost;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.PetReturnService;
import com.gulutown.service.PostCommentService;
import com.gulutown.vo.MissingPetVO;
import com.gulutown.vo.PostCommentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 宠物回家相关接口
 */
@RestController
@RequestMapping("/community/petReturn")
@Slf4j
public class PetReturnController {

    @Autowired
    private PetReturnService petReturnService;
    @Autowired
    private PostCommentService postCommentService;

    /**
     * 查询所有宠物回家帖子
     * @return 宠物帖子
     */
    @GetMapping("/queryAll")
    public Result<PageResult> queryAll(UsersPageDTO usersPageDTO) {
        log.info("查询首页失踪宠物帖子,{}",usersPageDTO);
        PageResult page = petReturnService.queryAll(usersPageDTO);
        return Result.success(page);
    }

    /**
     * 根据宠物回家帖子删除帖子
     * @return 响应
     */
    @DeleteMapping("/{postId}")
    public Result<Object> remove(@PathVariable Long postId) {
        log.info("根据宠物回家帖子删除帖子,{}",postId);
        petReturnService.remove(postId);
        return Result.success();
    }

    /**
     * 将帖子的宠物状态修改为已找到
     * @return 响应
     */
    @PutMapping("/{postId}")
    public Result<Object> update(@PathVariable Long postId) {
        log.info("将帖子的宠物状态修改为已找到,{}",postId);
        petReturnService.update(postId);
        return Result.success();
    }

    /**
     * 根据帖子id查询评论
     * @param postId 帖子id
     * @return 返回数据
     */
    @GetMapping("/comment/{postId}")
    public Result<List<PostCommentVO>> queryComment(@PathVariable Long postId) {
        log.info("根据帖子id查询评论,{}",postId);
        List<PostCommentVO> postCommentVOList = postCommentService.queryComment(postId);
        return Result.success(postCommentVOList);
    }


}

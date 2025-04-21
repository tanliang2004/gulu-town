package com.gulutown.controller.community;

import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.PostCommentService;
import com.gulutown.service.SquareService;
import com.gulutown.vo.PostCommentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 社区广场控制层
 */
@RestController
@RequestMapping("/community/square")
@Slf4j
public class SquareController {

    @Autowired
    private SquareService squareService;
    @Autowired
    private PostCommentService postCommentService;


    /**
     * 社区帖子分页查询
     * @return 返回数据
     */
    @GetMapping("/page")
    public Result<PageResult> page(ProductSortPageDTO productSortPageDTO) {
        log.info("社区广场帖子分页查询，{}",productSortPageDTO);
        PageResult pageResult = squareService.page(productSortPageDTO);
        return Result.success(pageResult);
    }


    /**
     * 根据帖子id查询评论
     * @param postId 帖子id
     * @return 返回数据
     */
    @GetMapping("/{postId}")
    public Result<List<PostCommentVO>> queryComment(@PathVariable Long postId) {
        log.info("根据帖子id查询评论,{}",postId);
        List<PostCommentVO> postCommentVOList = postCommentService.queryComment(postId);
        return Result.success(postCommentVOList);
    }


    /**
     * 根据帖子id删除帖子
     * @param postId 帖子id
     * @return 响应
     */
    @DeleteMapping("/{postId}")
    public Result<Object> remove(@PathVariable Long postId) {
        log.info("根据帖子id删除帖子，{}",postId);
        squareService.remove(postId);
        return Result.success();
    }

}

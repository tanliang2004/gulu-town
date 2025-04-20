package com.gulutown.controller.community;

import com.gulutown.dto.ProductPageDTO;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.SquareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 社区广场控制层
 */
@RestController
@RequestMapping("/community/square")
@Slf4j
public class SquareController {

    @Autowired
    private SquareService squareService;

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

}

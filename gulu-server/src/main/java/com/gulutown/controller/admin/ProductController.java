package com.gulutown.controller.admin;


import com.gulutown.dto.ProductPageDTO;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品相关接口
 */
@RestController
@RequestMapping("/admin/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 分页查询商品
     * @param productPageDTO 分页数据
     * @return 返回数据
     */
    @GetMapping("/page")
    public Result<PageResult> pageQuery(ProductPageDTO productPageDTO) {
        log.info("商品分页查询,{}",productPageDTO);
        PageResult pageResult = productService.pageQuery(productPageDTO);
        return Result.success(pageResult);
    }



}

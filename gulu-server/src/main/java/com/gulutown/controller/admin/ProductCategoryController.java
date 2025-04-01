package com.gulutown.controller.admin;

import com.gulutown.dto.CommodityCategoryDTO;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.CommodityCategory;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类相关接口
 */
@RestController
@RequestMapping("/admin/product")
@Slf4j
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productService;

    /**
     * 分页查询商品分类
     * @return 响应
     */
    @GetMapping("/categories")
    public Result<PageResult> page(ProductSortPageDTO productSortPageDTO) {
        log.info("查询商品分类信息：{}",productSortPageDTO);
        PageResult pageResult = productService.page(productSortPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增商品分类
     * @param commodityCategoryDTO 前端传入数据
     * @return 响应
     */
    @PostMapping("/add")
    public Result add(@RequestBody CommodityCategoryDTO commodityCategoryDTO) {
        log.info("新增商品分类：{}",commodityCategoryDTO);
        productService.add(commodityCategoryDTO);
        return Result.success();
    }

    /**
     * 根据id查询商品分类
     * @param id 商品分类id
     * @return 响应数据
     */
    @GetMapping("/{id}")
    public Result<CommodityCategory> queryById(@PathVariable Long id) {
        log.info("根据id查询商品分类ID：{}",id);
        CommodityCategory commodityCategory = productService.queryById(id);
        return Result.success(commodityCategory);
    }

    /**
     * 修改商品分类信息
     * @param commodityCategoryDTO 前端传入数据
     * @return 响应
     */
    @PutMapping
    public Result edit(@RequestBody CommodityCategoryDTO commodityCategoryDTO) {
        log.info("修改商品信息：{}",commodityCategoryDTO);
        productService.edit(commodityCategoryDTO);
        return Result.success();
    }

    /**
     * 根据ID删除商品分类
     * @param id 删除商品分类的ID
     * @return 响应
     */
    @DeleteMapping("/{id}")
    public Result remove(@PathVariable Long id) {
        log.info("根据ID删除商品分类：{}",id);
        productService.remove(id);
        return Result.success();
    }

    /**
     * 查询商品分类
     * @return 返回数据
     */
    @GetMapping("/categoryAll")
    public Result<List<CommodityCategory>> queryAll() {
        log.info("查询商品分类");
        List<CommodityCategory> list = productService.  queryAll();
        return Result.success(list);
    }

}

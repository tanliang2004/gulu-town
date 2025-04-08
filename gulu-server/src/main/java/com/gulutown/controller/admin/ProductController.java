package com.gulutown.controller.admin;


import com.gulutown.dto.CommodityDTO;
import com.gulutown.dto.ProductPageDTO;
import com.gulutown.entity.CommodityInfo;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.ProductService;
import com.gulutown.utils.CodeUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 添加商品
     * @param commodityDTO 添加的具体数据
     * @return 响应
     */
    @PostMapping
    public Result<Object> add(@RequestBody CommodityDTO commodityDTO) {
        log.info("添加商品：{}",commodityDTO);
        productService.add(commodityDTO);
        return Result.success();
    }

    /**
     * 根据商品id查询商品
     * @param id 商品id
     * @return 返回数据
     */
    @GetMapping("/commodity/{id}")
    public Result<CommodityInfo> queryById(@PathVariable Long id) {
        log.info("根据id查询商品，{}",id);
        CommodityInfo commodityInfo = productService.queryById(id);
        return Result.success(commodityInfo);
    }

    /**
     * 修改商品
     * @return 响应
     */
    @PutMapping("/edit")
    public Result<Object> edit(@RequestBody CommodityDTO commodityDTO) {
        log.info("修改商品信息，{}",commodityDTO);
        productService.edit(commodityDTO);
        return Result.success();
    }

    /**
     * 根据id删除商品
     * @param id 商品id
     * @return 响应
     */
    @DeleteMapping("/commodity/{id}")
    public Result remove(@PathVariable Long id) {
        log.info("删除商品，{}",id);
        productService.remove(id);
        return Result.success();
    }



}

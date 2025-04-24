package com.gulutown.controller.admin;

import com.gulutown.dto.ProductPageDTO;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.PetInfo;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 宠物管理控制层
 */
@RestController
@RequestMapping("/admin/pet")
@Slf4j
public class PetController {

    @Autowired
    private PetService petService;

    /**
     * 宠物信息分页查询
     * @param productSortPageDTO 分页数据
     * @return 返回数据
     */
    @GetMapping("/page")
    public Result<PageResult> page(ProductSortPageDTO productSortPageDTO) {
        log.info("宠物信息分页查询，{}",productSortPageDTO);
        PageResult pageResult = petService.page(productSortPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据用户id查询宠物信息
     * @param userId 用户id
     * @return 返回数据
     */
    @GetMapping("/{userId}")
    public Result<List<PetInfo>> queryByUserId(@PathVariable Long userId) {
        log.info("根据用户id查询宠物信息");
        List<PetInfo> petInfos = petService.queryByUserId(userId);
        return Result.success(petInfos);
    }

}

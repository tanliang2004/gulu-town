package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.PetInfo;
import com.gulutown.mapper.PetMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.PetService;
import com.gulutown.vo.PetInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    /**
     * 宠物信息分页查询
     * @param productSortPageDTO 分页数据
     * @return 返回数据
     */
    public PageResult page(ProductSortPageDTO productSortPageDTO) {
        //开启分页
        PageHelper.startPage(productSortPageDTO.getPage(),productSortPageDTO.getPageSize());
        //查询数据
        Page<PetInfoVO> page = petMapper.selectPage();
        return PageResult.builder()
                .total(page.getTotal())
                .records(page.getResult())
                .build();
    }

    /**
     * 根据用户id查询宠物信息
     * @param userId 用户id
     * @return 返回数据
     */
    public List<PetInfo> queryByUserId(Long userId) {
        return petMapper.selectByUserId(userId);
    }
}

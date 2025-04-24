package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.entity.PetInfo;
import com.gulutown.vo.PetInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PetMapper {

    Page<PetInfoVO> selectPage();

    @Select("select * from pet_info where user_id = #{userId}")
    List<PetInfo> selectByUserId(Long userId);
}

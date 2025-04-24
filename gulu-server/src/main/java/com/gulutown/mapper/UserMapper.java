package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.dto.UsersPageDTO;
import com.gulutown.entity.User;
import com.gulutown.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 分页查询用户信息
     * @param usersPageDTO 分页数据
     * @return 返回数据
     */
    Page<UserVO> PageQuery(UsersPageDTO usersPageDTO);

    @Select("select * from user where id = #{id}")
    UserVO selectById(Long id);
}

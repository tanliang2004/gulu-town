package com.gulutown.service;

import com.gulutown.dto.UsersPageDTO;
import com.gulutown.entity.User;
import com.gulutown.result.PageResult;
import com.gulutown.vo.UserVO;

public interface UserService {
    /**
     * 分页查询用户信息
     * @param usersPageDTO 分页数据
     * @return 返回数据
     */
    PageResult page(UsersPageDTO usersPageDTO);

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回数据
     */
    UserVO queryById(Long id);
}

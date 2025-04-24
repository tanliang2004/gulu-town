package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.UsersPageDTO;
import com.gulutown.entity.User;
import com.gulutown.mapper.UserMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.UserService;
import com.gulutown.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询用户信息
     * @param usersPageDTO 分页数据
     * @return 返回数据
     */
    public PageResult page(UsersPageDTO usersPageDTO) {
        PageHelper.startPage(usersPageDTO.getPage(), usersPageDTO.getPageSize());
        Page<UserVO> page = userMapper.PageQuery(usersPageDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回数据
     */
    public UserVO queryById(Long id) {
        return userMapper.selectById(id);
    }
}

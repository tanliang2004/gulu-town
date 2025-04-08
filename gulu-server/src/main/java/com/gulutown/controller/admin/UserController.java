package com.gulutown.controller.admin;

import com.gulutown.dto.UsersPageDTO;
import com.gulutown.entity.User;
import com.gulutown.result.PageResult;
import com.gulutown.result.Result;
import com.gulutown.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台管理相关接口
 */
@RestController
@RequestMapping("/admin/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询用户信息
     * @param usersPageDTO 分页数据
     * @return 返回数据
     */
    @GetMapping("/page")
    public Result<PageResult> page(UsersPageDTO usersPageDTO) {
        log.info("分页查询用户，{}",usersPageDTO);
        PageResult pageResult = userService.page(usersPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 返回数据
     */
    @GetMapping("/{id}")
    public Result<User> queryById(@PathVariable Long id) {
        log.info("根据id查询用户信息,{}",id);
        User user = userService.queryById(id);
        return Result.success(user);
    }

}

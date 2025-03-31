package com.gulutown.service;

import com.gulutown.dto.EmployeeLoginDTO;
import com.gulutown.vo.EmployeeLoginVO;

public interface EmployeeService {

    /**
     * 登录
     * @param employeeLoginDTO 前端请求数据
     * @return token
     */
    EmployeeLoginVO login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 管理员注册
     * @param employeeLoginDTO 注册信息
     */
    void register(EmployeeLoginDTO employeeLoginDTO);
}

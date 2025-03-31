package com.gulutown.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gulutown.constant.JwtClaimsConstant;
import com.gulutown.constant.MessageConstant;
import com.gulutown.dto.EmployeeLoginDTO;
import com.gulutown.entity.Employee;
import com.gulutown.exception.EmailNotRegisteredException;
import com.gulutown.exception.PasswordErrorException;
import com.gulutown.mapper.EmployeeMapper;
import com.gulutown.properties.JwtProperties;
import com.gulutown.service.EmployeeService;
import com.gulutown.utils.JwtUtil;
import com.gulutown.vo.EmployeeLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private JwtProperties jwtProperties;


    /**
     * 管理员登录
     *
     * @param employeeLoginDTO 前端请求数据
     * @return token
     */
    public EmployeeLoginVO login(EmployeeLoginDTO employeeLoginDTO) {
        //将employeeLoginDTO封装到Employee实体中
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeLoginDTO, employee);
        //根据邮箱查询emp
        Employee emp = employeeMapper.selectDynamic(employee);
        if (emp == null) {
            //抛出业务异常(该邮箱未注册)
            throw new EmailNotRegisteredException(MessageConstant.EMAIL_NOT_REGISTERED);
        }
        //查看密码是否正确
        String pswMD = DigestUtils.md5DigestAsHex(employee.getPassword().getBytes(StandardCharsets.UTF_8));
        if (!pswMD.equals(emp.getPassword())) {
            //抛出业务异常(密码错误)
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //登录成功生产JWT令牌并封装返回
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMPLOYEE_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        //封装结果
        return EmployeeLoginVO.builder()
                .id(emp.getId())
                .email(emp.getEmail())
                .name(emp.getName())
                .token(token)
                .build();
    }

    /**
     * 管理员注册
     * @param employeeLoginDTO 注册信息
     */
    public void register(EmployeeLoginDTO employeeLoginDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeLoginDTO,employee);

        // 查询当前邮箱是否已经注册
        Employee emp = employeeMapper.selectByEmail(employee.getEmail());
        if (emp != null) {
            //抛出业务异常（邮箱已注册）
            throw new EmailNotRegisteredException(MessageConstant.EMAIL_REGISTERED);
        }
        //增加管理员
        employee.setCreateTime(LocalDateTime.now());
        //密码进行加密处理
        employee.setPassword(
            DigestUtils.md5DigestAsHex(employee.getPassword().getBytes(StandardCharsets.UTF_8))
        );
        employeeMapper.insert(employee);


    }
}

package com.gulutown.controller.admin;

import com.gulutown.constant.EmailCodeMessage;
import com.gulutown.constant.MessageConstant;
import com.gulutown.dto.EmployeeLoginDTO;
import com.gulutown.exception.EmailNotRegisteredException;
import com.gulutown.result.Result;
import com.gulutown.service.EmployeeService;
import com.gulutown.service.MailService;
import com.gulutown.vo.EmployeeLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 员工相关接口
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MailService mailService;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 登录接口
     *
     * @param employeeLoginDTO email and password
     * @return token
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("管理员登录请求：{}", employeeLoginDTO);
        EmployeeLoginVO employeeLoginVO = employeeService.login(employeeLoginDTO);
        return Result.success(employeeLoginVO);
    }


    /**
     * 发送邮件
     *
     * @param email 邮件发送地址
     * @return 响应
     */
    @GetMapping("/send-code")
    public Result sendCode(@RequestParam String email) {
        log.info("发送邮件：{}", email);
        //生产随机六位数字验证码
        String code = String.valueOf((int) (Math.random() * (999999 - 100000 + 1)) + 100000);
        mailService.sendTextMessage(email,
                EmailCodeMessage.SUBJECT,
                EmailCodeMessage.CODE_TIPS + code + EmailCodeMessage.CODE_TIME_TIPS
        );
        // 将严重码存入redis中5分钟失效
        try {
            redisTemplate.opsForValue().set(email,code, 5, TimeUnit.MINUTES);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Result.success();
    }

    /**
     * 管理员注册
     * @param employeeLoginDTO 注册信息
     * @return 响应
     */
    @PostMapping("/register")
    public Result sendCode(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("管理员注册：{}",employeeLoginDTO);
        //判断验证码是否过期
        Boolean b = redisTemplate.hasKey(employeeLoginDTO.getEmail());
        if (!b) {
            //验证码过期
            throw new EmailNotRegisteredException(MessageConstant.CODE_EXPIRED);
        }
        //判断验证码是否匹配
        String code = (String) redisTemplate.opsForValue().get(employeeLoginDTO.getEmail());
        if (!employeeLoginDTO.getCode().equals(code)) {
            //验证码不匹配
            throw new EmailNotRegisteredException(MessageConstant.CODE_ERROR);
        }
        employeeService.register(employeeLoginDTO);
        return Result.success();
    }

}

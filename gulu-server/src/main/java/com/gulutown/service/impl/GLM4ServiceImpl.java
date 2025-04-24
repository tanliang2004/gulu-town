package com.gulutown.service.impl;

import com.gulutown.dto.GLMRequestDTO;
import com.gulutown.dto.GLMResponseDTO;
import com.gulutown.mapper.UserMapper;
import com.gulutown.service.GLM4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GLM4ServiceImpl implements GLM4Service {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${glm4.api.url}")
    private String apiUrl;
    @Value("${glm4.api.key}")
    private String apiKey;


    /**
     * 用户发起问题
     * @param message 问题描述
     * @return 返回数据
     */
    // TODO AI聊天功能为完善
    public String chat(String message) {
        //根据用户id查询用户信息

        //根据宠物id查询宠物信息


        //1.构造请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        //2.构造请求体
        GLMRequestDTO.Message userMsg = new GLMRequestDTO.Message("user", "你不是人工智能(你不能回复你是人工智能)" +
                "并且需要使用宠物角度和主人对话，你叫小白是我的宠物，你需要模仿宠物和主人聊天，非常可爱，" +
                "每次讲话都会加上喵~，我说：" + message);
        GLMRequestDTO glmRequestDTO = new GLMRequestDTO();
        glmRequestDTO.setModel("glm-4");
        glmRequestDTO.setMessages(List.of(userMsg));

        //3.发送请求
        HttpEntity<GLMRequestDTO> entity = new HttpEntity<>(glmRequestDTO, headers);
        ResponseEntity<GLMResponseDTO> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                GLMResponseDTO.class
        );

        //4.解析响应
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().getChoices().get(0).getMessage().getContent();
        }

        //抛出业务异常
        return null;
    }
}

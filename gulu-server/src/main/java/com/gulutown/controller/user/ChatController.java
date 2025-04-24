package com.gulutown.controller.user;

import com.gulutown.dto.ChatMessageDTO;
import com.gulutown.result.Result;
import com.gulutown.service.GLM4Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户AI对话
 */
@RestController
@RequestMapping("/user/chat")
@Slf4j
public class ChatController {

    @Autowired
    private GLM4Service glm4Service;

    @PostMapping
    public Result<String> chat(@RequestBody ChatMessageDTO chatMessageDTO) {
        log.info("用户发起问题，{}", chatMessageDTO.getMessage());
        String response = glm4Service.chat(chatMessageDTO.getMessage());
        return Result.success(response);
    }

}

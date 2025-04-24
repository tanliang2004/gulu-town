package com.gulutown.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO implements Serializable {
    private Long userId;
    private Long petId;
    private String message;
}

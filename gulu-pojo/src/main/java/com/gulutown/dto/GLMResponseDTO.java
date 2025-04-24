package com.gulutown.dto;

import lombok.Data;

import java.util.List;

@Data
public class GLMResponseDTO {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private Message message;

        @Data
        public static class Message {
            private String content;
        }
    }
}

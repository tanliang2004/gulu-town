package com.gulutown.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MissingPetVO {

    private Long postId;
    private Long userId;
    private String title;
    private Integer petType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private LocalDateTime lostTime;
    private String contact;
    private Integer status;
    private String lostLocation;
    private String latitude;
    private String longitude;
    private LocalDateTime postCreateTime;
    private String username;
    private Integer gender;
    private String email;
    private String phone;
    private String avatar;
    private Integer likes;//点赞数量和
    private Integer comments;//评论数量和
    private List<String> imageUrls;

}

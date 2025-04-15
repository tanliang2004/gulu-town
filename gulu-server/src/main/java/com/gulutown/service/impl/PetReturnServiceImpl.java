package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.UsersPageDTO;
import com.gulutown.entity.MissingPetImage;
import com.gulutown.entity.MissingPetPost;
import com.gulutown.entity.PostComment;
import com.gulutown.entity.PostLike;
import com.gulutown.mapper.PetReturnMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.PetReturnService;
import com.gulutown.vo.MissingPetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PetReturnServiceImpl implements PetReturnService {

    @Autowired
    private PetReturnMapper petReturnMapper;


    /**
     * 查询所有宠物回家帖子
     *
     * @param usersPageDTO 宠物帖子
     * @return 返回数据
     */
    @Transactional
    public PageResult queryAll(UsersPageDTO usersPageDTO) {
        //开启分页查询
        PageHelper.startPage(usersPageDTO.getPage(), usersPageDTO.getPageSize());

        //查询用户信息和帖子信息
        Page<MissingPetVO> page = petReturnMapper.page();
        List<MissingPetVO> posts = page.getResult();

        //批量处理图片查询，获取帖子id;
        List<Long> postIds = posts.stream().map(new Function<MissingPetVO, Long>() {
            @Override
            public Long apply(MissingPetVO missingPetVO) {
                return missingPetVO.getPostId();
            }
        }).toList();

        //批量处理帖子id查询图片
        Map<Long, List<MissingPetImage>> imageMap = petReturnMapper.findImagesByPostIds(postIds)
                .stream()
                .collect(Collectors.groupingBy(MissingPetImage::getPostId));

        //数据装配
        posts.forEach(post -> {
            List<MissingPetImage> images = imageMap.getOrDefault(post.getPostId(), Collections.emptyList());
            post.setImageUrls(images.stream()
                    .map(MissingPetImage::getImageUrl)
                    .collect(Collectors.toList()));
        });


        //数据打包
        return PageResult.builder()
                .total(page.getTotal())
                .records(posts)
                .build();
    }

    /**
     * 根据宠物回家帖子删除帖子
     * @param postId 帖子id
     */
    @Transactional
    public void remove(Long postId) {
        //1.删除宠物回家表信息
        petReturnMapper.deleteById(postId);
        //2.删除相关图片信息
        petReturnMapper.deleteImageById(postId);
        //3.删除相关评论信息
        petReturnMapper.deleteCommentById(postId);
        //4.删除相关点赞信息
        petReturnMapper.deleteLikeById(postId);
    }

    /**
     * 将帖子的宠物状态修改为已找到
     * @param postId 帖子id
     */
    public void update(Long postId) {
        petReturnMapper.update(postId);
    }


}

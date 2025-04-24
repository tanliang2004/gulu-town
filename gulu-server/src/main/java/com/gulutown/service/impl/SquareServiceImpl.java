package com.gulutown.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gulutown.dto.ProductSortPageDTO;
import com.gulutown.entity.MissingPetImage;
import com.gulutown.mapper.PetReturnMapper;
import com.gulutown.mapper.PostCommentMapper;
import com.gulutown.mapper.SquareMapper;
import com.gulutown.result.PageResult;
import com.gulutown.service.PetReturnService;
import com.gulutown.service.SquareService;
import com.gulutown.vo.SquarePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SquareServiceImpl implements SquareService {

    @Autowired
    private SquareMapper squareMapper;
    @Autowired
    private PetReturnMapper petReturnMapper;

    /**
     * 社区帖子分页查询
     *
     * @param productSortPageDTO 分页数据
     * @return 返回数据
     */
    @Transactional
    public PageResult page(ProductSortPageDTO productSortPageDTO) {
        //开启分页查询
        PageHelper.startPage(productSortPageDTO.getPage(), productSortPageDTO.getPageSize());

        //查询基本数据（帖子基本信息和用户基本信息）
        Page<SquarePostVO> page = squareMapper.page();
        List<SquarePostVO> result = page.getResult();

        //批量获取帖子id
        List<Long> postIds = result.stream().map(new Function<SquarePostVO, Long>() {
            @Override
            public Long apply(SquarePostVO squarePostVO) {
                return squarePostVO.getPostId();
            }
        }).toList();

        //获取图像信息
        Map<Long, List<MissingPetImage>> imageMap = squareMapper.findImagesByPostIds(postIds).stream()
                .collect(Collectors.groupingBy(MissingPetImage::getPostId));

        //数据装配
        result.forEach(post -> {
            List<MissingPetImage> images = imageMap.getOrDefault(post.getPostId(), Collections.emptyList());
            post.setImageUrl(images.stream()
                    .map(MissingPetImage::getImageUrl)
                    .collect(Collectors.toList()));
        });


        return PageResult.builder()
                .total(page.getTotal())
                .records(result).build();
    }

    /**
     * 根据帖子id删除帖子
     * @param postId 帖子id
     */
    @Transactional
    public void remove(Long postId) {
        //删除主帖子
        squareMapper.remove(postId);
        //删除相关点赞和评论信息
        petReturnMapper.deleteCommentById(postId);
        petReturnMapper.deleteLikeById(postId);
        //删除图片信息
        squareMapper.deleteImageById(postId);
    }
}

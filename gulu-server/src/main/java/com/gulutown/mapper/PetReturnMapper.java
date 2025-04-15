package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.entity.MissingPetImage;
import com.gulutown.entity.PostComment;
import com.gulutown.entity.PostLike;
import com.gulutown.vo.MissingPetVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PetReturnMapper {

    /**
     * 查询所有宠物回家帖子
     * @return 返回数据
     */
    @Result(property = "postCreateTime",column = "post_create_time")
    Page<MissingPetVO> page();

    // 查询关联图片
    @Select("SELECT image_url,post_id  FROM missing_pet_image WHERE post_id = #{postId}")
    List<MissingPetImage> findImagesByPostId(Long postId);

    List<MissingPetImage> findImagesByPostIds(List<Long> postIds);

    @Delete("delete from missing_pet_post where post_id = #{postId}")
    void deleteById(Long postId);

    @Delete("delete from missing_pet_image where post_id = #{postId}")
    void deleteImageById(Long postId);

    @Delete("delete from post_comment where target_id = #{postId}")
    void deleteCommentById(Long postId);

    @Delete("delete from post_like where target_id = #{postId}")
    void deleteLikeById(Long postId);

    @Update("update missing_pet_post set status = 2 where post_id = #{post_id}")
    void update(Long postId);
}

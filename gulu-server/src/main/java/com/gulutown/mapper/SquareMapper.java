package com.gulutown.mapper;

import com.github.pagehelper.Page;
import com.gulutown.entity.MissingPetImage;
import com.gulutown.vo.SquarePostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SquareMapper {

    @Select("select sp.post_id,sp.user_id,sp.content,sp.likes,sp.comments,\n" +
            "sp.longitude,sp.latitude,u.gender,u.username,u.avatar as avatar,sp.create_time,null as imageUrl\n" +
            "FROM square_post sp left JOIN `user` u\n" +
            "ON sp.user_id = u.id")
    Page<SquarePostVO> page();

    List<MissingPetImage> findImagesByPostIds(List<Long> postIds);
}

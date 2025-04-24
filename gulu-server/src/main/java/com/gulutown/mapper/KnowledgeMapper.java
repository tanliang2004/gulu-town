package com.gulutown.mapper;

import com.gulutown.entity.KnowledgePost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KnowledgeMapper {

    @Select("select * from knowledge_post")
    List<KnowledgePost> selectAll();

    @Delete("delete from knowledge_post where post_id = #{postId}")
    void deleteById(Long postId);

    @Insert("insert into knowledge_post(title, avatar, content,type, create_time) VALUES" +
            " (#{title},#{avatar},#{content},#{type},#{createTime})")
    void insert(KnowledgePost knowledgePost);
}

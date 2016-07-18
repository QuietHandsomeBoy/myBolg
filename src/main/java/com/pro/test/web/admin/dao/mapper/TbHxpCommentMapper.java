package com.pro.test.web.admin.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.admin.entity.TbHxpComment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpCommentMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_comment",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_comment (id, comment_id, ",
        "article_id, comment_context, ",
        "user_id, user_name, user_head_portrait, ",
        "comment_ip, comment_likes, ",
        "create_date)",
        "values (#{id,jdbcType=CHAR}, #{commentId,jdbcType=CHAR}, ",
        "#{articleId,jdbcType=CHAR}, #{commentContext,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=CHAR}, #{userName,jdbcType=VARCHAR}, #{userHeadPortrait,jdbcType=VARCHAR}, ",
        "#{commentIp,jdbcType=VARCHAR}, #{commentLikes,jdbcType=INTEGER}, ",
        "#{createDate,jdbcType=DATE})"
    })
    int insert(TbHxpComment record);

    @Select({
        "select",
        "id, comment_id, article_id, comment_context, user_id, user_name, user_head_portrait, ",
        "comment_ip, comment_likes, create_date",
        "from tb_hxp_comment",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.CHAR),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR),
        @Result(column="comment_context", property="commentContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head_portrait", property="userHeadPortrait", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_ip", property="commentIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_likes", property="commentLikes", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    TbHxpComment selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, comment_id, article_id, comment_context, user_id, user_name, user_head_portrait, ",
        "comment_ip, comment_likes, create_date",
        "from tb_hxp_comment",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.CHAR),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR),
        @Result(column="comment_context", property="commentContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head_portrait", property="userHeadPortrait", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_ip", property="commentIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_likes", property="commentLikes", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    List<TbHxpComment> selectAll();

    @Update({
        "update tb_hxp_comment",
        "set comment_id = #{commentId,jdbcType=CHAR},",
          "article_id = #{articleId,jdbcType=CHAR},",
          "comment_context = #{commentContext,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=CHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_head_portrait = #{userHeadPortrait,jdbcType=VARCHAR},",
          "comment_ip = #{commentIp,jdbcType=VARCHAR},",
          "comment_likes = #{commentLikes,jdbcType=INTEGER},",
          "create_date = #{createDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TbHxpComment record);
}
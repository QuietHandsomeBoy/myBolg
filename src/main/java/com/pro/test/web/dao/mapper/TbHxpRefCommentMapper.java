package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpRefComment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpRefCommentMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_ref_comment",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_ref_comment (id, article_id, ",
        "comment_id, ref_comment_id, ",
        "ref_comment_context, user_id, ",
        "user_name, user_head_portrait, ",
        "to_user_name, to_user_id, ",
        "ref_comment_ip, create_date)",
        "values (#{id,jdbcType=CHAR}, #{articleId,jdbcType=CHAR}, ",
        "#{commentId,jdbcType=CHAR}, #{refCommentId,jdbcType=CHAR}, ",
        "#{refCommentContext,jdbcType=VARCHAR}, #{userId,jdbcType=CHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{userHeadPortrait,jdbcType=VARCHAR}, ",
        "#{toUserName,jdbcType=CHAR}, #{toUserId,jdbcType=VARCHAR}, ",
        "#{refCommentIp,jdbcType=VARCHAR}, #{createDate,jdbcType=DATE})"
    })
    int insert(TbHxpRefComment record);

    @Select({
        "select",
        "id, article_id, comment_id, ref_comment_id, ref_comment_context, user_id, user_name, ",
        "user_head_portrait, to_user_name, to_user_id, ref_comment_ip, create_date",
        "from tb_hxp_ref_comment",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.CHAR),
        @Result(column="ref_comment_id", property="refCommentId", jdbcType=JdbcType.CHAR),
        @Result(column="ref_comment_context", property="refCommentContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head_portrait", property="userHeadPortrait", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_name", property="toUserName", jdbcType=JdbcType.CHAR),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_ip", property="refCommentIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    TbHxpRefComment selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, article_id, comment_id, ref_comment_id, ref_comment_context, user_id, user_name, ",
        "user_head_portrait, to_user_name, to_user_id, ref_comment_ip, create_date",
        "from tb_hxp_ref_comment",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.CHAR),
        @Result(column="ref_comment_id", property="refCommentId", jdbcType=JdbcType.CHAR),
        @Result(column="ref_comment_context", property="refCommentContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head_portrait", property="userHeadPortrait", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_name", property="toUserName", jdbcType=JdbcType.CHAR),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_ip", property="refCommentIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    List<TbHxpRefComment> selectAll();

    @Update({
        "update tb_hxp_ref_comment",
        "set article_id = #{articleId,jdbcType=CHAR},",
          "comment_id = #{commentId,jdbcType=CHAR},",
          "ref_comment_id = #{refCommentId,jdbcType=CHAR},",
          "ref_comment_context = #{refCommentContext,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=CHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_head_portrait = #{userHeadPortrait,jdbcType=VARCHAR},",
          "to_user_name = #{toUserName,jdbcType=CHAR},",
          "to_user_id = #{toUserId,jdbcType=VARCHAR},",
          "ref_comment_ip = #{refCommentIp,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TbHxpRefComment record);
}
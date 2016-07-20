package com.pro.test.web.admin.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.admin.entity.TbHxpRefComment;
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
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_ref_comment (id, article_id, ",
        "comment_id, ref_comment_id, ",
        "ref_comment_context, user_id, ",
        "user_name, user_head_portrait, ",
        "to_user_name, to_user_id, ",
        "ref_comment_ip, create_date, ",
        "create_by, update_date, ",
        "update_by, is_deleted)",
        "values (#{id,jdbcType=VARCHAR}, #{articleId,jdbcType=VARCHAR}, ",
        "#{commentId,jdbcType=VARCHAR}, #{refCommentId,jdbcType=VARCHAR}, ",
        "#{refCommentContext,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{userHeadPortrait,jdbcType=VARCHAR}, ",
        "#{toUserName,jdbcType=VARCHAR}, #{toUserId,jdbcType=VARCHAR}, ",
        "#{refCommentIp,jdbcType=VARCHAR}, #{createDate,jdbcType=DATE}, ",
        "#{createBy,jdbcType=VARCHAR}, #{updateDate,jdbcType=DATE}, ",
        "#{updateBy,jdbcType=VARCHAR}, #{isDeleted,jdbcType=INTEGER})"
    })
    int insert(TbHxpRefComment record);

    @Select({
        "select",
        "id, article_id, comment_id, ref_comment_id, ref_comment_context, user_id, user_name, ",
        "user_head_portrait, to_user_name, to_user_id, ref_comment_ip, create_date, create_by, ",
        "update_date, update_by, is_deleted",
        "from tb_hxp_ref_comment",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_id", property="refCommentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_context", property="refCommentContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head_portrait", property="userHeadPortrait", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_name", property="toUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_ip", property="refCommentIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER)
    })
    TbHxpRefComment selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, article_id, comment_id, ref_comment_id, ref_comment_context, user_id, user_name, ",
        "user_head_portrait, to_user_name, to_user_id, ref_comment_ip, create_date, create_by, ",
        "update_date, update_by, is_deleted",
        "from tb_hxp_ref_comment",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_id", property="refCommentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_context", property="refCommentContext", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head_portrait", property="userHeadPortrait", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_name", property="toUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ref_comment_ip", property="refCommentIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER)
    })
    List<TbHxpRefComment> selectAll();

    @Update({
        "update tb_hxp_ref_comment",
        "set article_id = #{articleId,jdbcType=VARCHAR},",
          "comment_id = #{commentId,jdbcType=VARCHAR},",
          "ref_comment_id = #{refCommentId,jdbcType=VARCHAR},",
          "ref_comment_context = #{refCommentContext,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_head_portrait = #{userHeadPortrait,jdbcType=VARCHAR},",
          "to_user_name = #{toUserName,jdbcType=VARCHAR},",
          "to_user_id = #{toUserId,jdbcType=VARCHAR},",
          "ref_comment_ip = #{refCommentIp,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=DATE},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TbHxpRefComment record);
}
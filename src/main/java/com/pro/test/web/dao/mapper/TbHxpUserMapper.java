package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpUserMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_user",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_user (id, user_id, user_name, ",
        "publish_count, comments_count, ",
        "like_tags)",
        "values (#{id,jdbcType=CHAR}, #{userId,jdbcType=CHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{publishCount,jdbcType=INTEGER}, #{commentsCount,jdbcType=INTEGER}, ",
        "#{likeTags,jdbcType=VARCHAR})"
    })
    int insert(TbHxpUser record);

    @Select({
        "select",
        "id, user_id, user_name, publish_count, comments_count, like_tags",
        "from tb_hxp_user",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_count", property="publishCount", jdbcType=JdbcType.INTEGER),
        @Result(column="comments_count", property="commentsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="like_tags", property="likeTags", jdbcType=JdbcType.VARCHAR)
    })
    TbHxpUser selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, user_id, user_name, publish_count, comments_count, like_tags",
        "from tb_hxp_user",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_count", property="publishCount", jdbcType=JdbcType.INTEGER),
        @Result(column="comments_count", property="commentsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="like_tags", property="likeTags", jdbcType=JdbcType.VARCHAR)
    })
    List<TbHxpUser> selectAll();

    @Update({
        "update tb_hxp_user",
        "set user_id = #{userId,jdbcType=CHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "publish_count = #{publishCount,jdbcType=INTEGER},",
          "comments_count = #{commentsCount,jdbcType=INTEGER},",
          "like_tags = #{likeTags,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TbHxpUser record);
}
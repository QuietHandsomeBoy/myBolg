package com.pro.test.web.admin.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.admin.entity.TbHxpArticleContent;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpArticleContentMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_article_content",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_article_content (id, article_id, ",
        "create_date, create_by, ",
        "update_date, update_by, ",
        "is_deleted, article_content)",
        "values (#{id,jdbcType=VARCHAR}, #{articleId,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=DATE}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=DATE}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{isDeleted,jdbcType=INTEGER}, #{articleContent,jdbcType=LONGVARCHAR})"
    })
    int insert(TbHxpArticleContent record);

    @Select({
        "select",
        "id, article_id, create_date, create_by, update_date, update_by, is_deleted, ",
        "article_content",
        "from tb_hxp_article_content",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    TbHxpArticleContent selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, article_id, create_date, create_by, update_date, update_by, is_deleted, ",
        "article_content",
        "from tb_hxp_article_content",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TbHxpArticleContent> selectAll();

    @Update({
        "update tb_hxp_article_content",
        "set article_id = #{articleId,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=DATE},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER},",
          "article_content = #{articleContent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TbHxpArticleContent record);
}
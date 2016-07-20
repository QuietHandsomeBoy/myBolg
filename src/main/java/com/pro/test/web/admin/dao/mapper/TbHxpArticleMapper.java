package com.pro.test.web.admin.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.admin.entity.TbHxpArticle;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpArticleMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_article",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_article (id, article_id, ",
        "article_title, article_introduced, ",
        "article_range, article_type, ",
        "article_author_id, article_author_name, ",
        "article_tags, last_comment_date, ",
        "comment_count, likes_count, ",
        "read_count, limit_comments, ",
        "is_public, on_top, ",
        "key_words, is_content_finish, ",
        "article_rights, article_status, ",
        "create_date, create_by, ",
        "update_date, update_by, ",
        "remark, is_deleted)",
        "values (#{id,jdbcType=VARCHAR}, #{articleId,jdbcType=VARCHAR}, ",
        "#{articleTitle,jdbcType=VARCHAR}, #{articleIntroduced,jdbcType=VARCHAR}, ",
        "#{articleRange,jdbcType=VARCHAR}, #{articleType,jdbcType=VARCHAR}, ",
        "#{articleAuthorId,jdbcType=VARCHAR}, #{articleAuthorName,jdbcType=VARCHAR}, ",
        "#{articleTags,jdbcType=VARCHAR}, #{lastCommentDate,jdbcType=DATE}, ",
        "#{commentCount,jdbcType=INTEGER}, #{likesCount,jdbcType=INTEGER}, ",
        "#{readCount,jdbcType=INTEGER}, #{limitComments,jdbcType=VARCHAR}, ",
        "#{isPublic,jdbcType=INTEGER}, #{onTop,jdbcType=INTEGER}, ",
        "#{keyWords,jdbcType=VARCHAR}, #{isContentFinish,jdbcType=INTEGER}, ",
        "#{articleRights,jdbcType=VARCHAR}, #{articleStatus,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=DATE}, #{createBy,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=DATE}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{isDeleted,jdbcType=INTEGER})"
    })
    int insert(TbHxpArticle record);

    @Select({
        "select",
        "id, article_id, article_title, article_introduced, article_range, article_type, ",
        "article_author_id, article_author_name, article_tags, last_comment_date, comment_count, ",
        "likes_count, read_count, limit_comments, is_public, on_top, key_words, is_content_finish, ",
        "article_rights, article_status, create_date, create_by, update_date, update_by, ",
        "remark, is_deleted",
        "from tb_hxp_article",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_introduced", property="articleIntroduced", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_range", property="articleRange", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_type", property="articleType", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_author_id", property="articleAuthorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_author_name", property="articleAuthorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_tags", property="articleTags", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_comment_date", property="lastCommentDate", jdbcType=JdbcType.DATE),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="likes_count", property="likesCount", jdbcType=JdbcType.INTEGER),
        @Result(column="read_count", property="readCount", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_comments", property="limitComments", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_public", property="isPublic", jdbcType=JdbcType.INTEGER),
        @Result(column="on_top", property="onTop", jdbcType=JdbcType.INTEGER),
        @Result(column="key_words", property="keyWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_content_finish", property="isContentFinish", jdbcType=JdbcType.INTEGER),
        @Result(column="article_rights", property="articleRights", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_status", property="articleStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER)
    })
    TbHxpArticle selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, article_id, article_title, article_introduced, article_range, article_type, ",
        "article_author_id, article_author_name, article_tags, last_comment_date, comment_count, ",
        "likes_count, read_count, limit_comments, is_public, on_top, key_words, is_content_finish, ",
        "article_rights, article_status, create_date, create_by, update_date, update_by, ",
        "remark, is_deleted",
        "from tb_hxp_article",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_introduced", property="articleIntroduced", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_range", property="articleRange", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_type", property="articleType", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_author_id", property="articleAuthorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_author_name", property="articleAuthorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_tags", property="articleTags", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_comment_date", property="lastCommentDate", jdbcType=JdbcType.DATE),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="likes_count", property="likesCount", jdbcType=JdbcType.INTEGER),
        @Result(column="read_count", property="readCount", jdbcType=JdbcType.INTEGER),
        @Result(column="limit_comments", property="limitComments", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_public", property="isPublic", jdbcType=JdbcType.INTEGER),
        @Result(column="on_top", property="onTop", jdbcType=JdbcType.INTEGER),
        @Result(column="key_words", property="keyWords", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_content_finish", property="isContentFinish", jdbcType=JdbcType.INTEGER),
        @Result(column="article_rights", property="articleRights", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_status", property="articleStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER)
    })
    List<TbHxpArticle> selectAll();

    @Update({
        "update tb_hxp_article",
        "set article_id = #{articleId,jdbcType=VARCHAR},",
          "article_title = #{articleTitle,jdbcType=VARCHAR},",
          "article_introduced = #{articleIntroduced,jdbcType=VARCHAR},",
          "article_range = #{articleRange,jdbcType=VARCHAR},",
          "article_type = #{articleType,jdbcType=VARCHAR},",
          "article_author_id = #{articleAuthorId,jdbcType=VARCHAR},",
          "article_author_name = #{articleAuthorName,jdbcType=VARCHAR},",
          "article_tags = #{articleTags,jdbcType=VARCHAR},",
          "last_comment_date = #{lastCommentDate,jdbcType=DATE},",
          "comment_count = #{commentCount,jdbcType=INTEGER},",
          "likes_count = #{likesCount,jdbcType=INTEGER},",
          "read_count = #{readCount,jdbcType=INTEGER},",
          "limit_comments = #{limitComments,jdbcType=VARCHAR},",
          "is_public = #{isPublic,jdbcType=INTEGER},",
          "on_top = #{onTop,jdbcType=INTEGER},",
          "key_words = #{keyWords,jdbcType=VARCHAR},",
          "is_content_finish = #{isContentFinish,jdbcType=INTEGER},",
          "article_rights = #{articleRights,jdbcType=VARCHAR},",
          "article_status = #{articleStatus,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=DATE},",
          "update_by = #{updateBy,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TbHxpArticle record);
}
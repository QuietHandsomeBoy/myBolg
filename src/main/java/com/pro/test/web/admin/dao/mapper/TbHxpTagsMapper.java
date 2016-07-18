package com.pro.test.web.admin.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.admin.entity.TbHxpTags;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpTagsMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_tags",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_tags (id, tag_id, tag_name, ",
        "tag_title, tag_img, ",
        "tag_count, create_date, ",
        "create_by, update_date, ",
        "update_by, remark)",
        "values (#{id,jdbcType=CHAR}, #{tagId,jdbcType=CHAR}, #{tagName,jdbcType=VARCHAR}, ",
        "#{tagTitle,jdbcType=VARCHAR}, #{tagImg,jdbcType=VARCHAR}, ",
        "#{tagCount,jdbcType=INTEGER}, #{createDate,jdbcType=DATE}, ",
        "#{createBy,jdbcType=CHAR}, #{updateDate,jdbcType=DATE}, ",
        "#{updateBy,jdbcType=CHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(TbHxpTags record);

    @Select({
        "select",
        "id, tag_id, tag_name, tag_title, tag_img, tag_count, create_date, create_by, ",
        "update_date, update_by, remark",
        "from tb_hxp_tags",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.CHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_title", property="tagTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_img", property="tagImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_count", property="tagCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.CHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.CHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    TbHxpTags selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, tag_id, tag_name, tag_title, tag_img, tag_count, create_date, create_by, ",
        "update_date, update_by, remark",
        "from tb_hxp_tags",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.CHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_title", property="tagTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_img", property="tagImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_count", property="tagCount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.CHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.DATE),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.CHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TbHxpTags> selectAll();

    @Update({
        "update tb_hxp_tags",
        "set tag_id = #{tagId,jdbcType=CHAR},",
          "tag_name = #{tagName,jdbcType=VARCHAR},",
          "tag_title = #{tagTitle,jdbcType=VARCHAR},",
          "tag_img = #{tagImg,jdbcType=VARCHAR},",
          "tag_count = #{tagCount,jdbcType=INTEGER},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_by = #{createBy,jdbcType=CHAR},",
          "update_date = #{updateDate,jdbcType=DATE},",
          "update_by = #{updateBy,jdbcType=CHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TbHxpTags record);
}
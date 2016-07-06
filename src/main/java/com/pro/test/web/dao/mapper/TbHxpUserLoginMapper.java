package com.pro.test.web.dao.mapper;

import com.pro.test.core.common.mybatis.dao.GenericMapper;
import com.pro.test.web.entity.TbHxpUserLogin;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TbHxpUserLoginMapper extends GenericMapper {
    @Delete({
        "delete from tb_hxp_user_login",
        "where id = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into tb_hxp_user_login (id, login_name, ",
        "login_password, user_id, ",
        "login_count, is_locked, ",
        "unlocked_date, ip_address, ",
        "last_login_time, status)",
        "values (#{id,jdbcType=CHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{loginPassword,jdbcType=VARCHAR}, #{userId,jdbcType=CHAR}, ",
        "#{loginCount,jdbcType=INTEGER}, #{isLocked,jdbcType=INTEGER}, ",
        "#{unlockedDate,jdbcType=DATE}, #{ipAddress,jdbcType=CHAR}, ",
        "#{lastLoginTime,jdbcType=DATE}, #{status,jdbcType=INTEGER})"
    })
    int insert(TbHxpUserLogin record);

    @Select({
        "select",
        "id, login_name, login_password, user_id, login_count, is_locked, unlocked_date, ",
        "ip_address, last_login_time, status",
        "from tb_hxp_user_login",
        "where id = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_password", property="loginPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="login_count", property="loginCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_locked", property="isLocked", jdbcType=JdbcType.INTEGER),
        @Result(column="unlocked_date", property="unlockedDate", jdbcType=JdbcType.DATE),
        @Result(column="ip_address", property="ipAddress", jdbcType=JdbcType.CHAR),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    TbHxpUserLogin selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, login_name, login_password, user_id, login_count, is_locked, unlocked_date, ",
        "ip_address, last_login_time, status",
        "from tb_hxp_user_login",
        "order by create_date desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_password", property="loginPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="login_count", property="loginCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_locked", property="isLocked", jdbcType=JdbcType.INTEGER),
        @Result(column="unlocked_date", property="unlockedDate", jdbcType=JdbcType.DATE),
        @Result(column="ip_address", property="ipAddress", jdbcType=JdbcType.CHAR),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<TbHxpUserLogin> selectAll();

    @Update({
        "update tb_hxp_user_login",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "login_password = #{loginPassword,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=CHAR},",
          "login_count = #{loginCount,jdbcType=INTEGER},",
          "is_locked = #{isLocked,jdbcType=INTEGER},",
          "unlocked_date = #{unlockedDate,jdbcType=DATE},",
          "ip_address = #{ipAddress,jdbcType=CHAR},",
          "last_login_time = #{lastLoginTime,jdbcType=DATE},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TbHxpUserLogin record);
}
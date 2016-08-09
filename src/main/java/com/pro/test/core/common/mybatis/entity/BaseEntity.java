package com.pro.test.core.common.mybatis.entity;

import com.pro.test.core.common.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hxpeng on 2016/8/9.
 */
public abstract class BaseEntity<ID extends Serializable> {

    @TableId
    private String id;

    @CreateDate
    private Date createDate;

    @CreateBy
    private String createBy;

    @LastUpdateDate
    private Date updateDate;

    @LastUpdateBy
    private String updateBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

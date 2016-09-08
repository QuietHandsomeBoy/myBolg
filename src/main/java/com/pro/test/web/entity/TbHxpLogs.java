package com.pro.test.web.entity;

import com.pro.test.core.common.annotation.CreateBy;
import com.pro.test.core.common.annotation.CreateByUserName;
import com.pro.test.core.common.annotation.CreateDate;
import com.pro.test.core.common.annotation.TableId;

import java.util.Date;

/**
 * Created by hxpeng on 2016/9/8.
 */
public class TbHxpLogs {
    @TableId
    private String id;

    private String operationMethod;

    private String operationContent;

    private String operationIp;

    @CreateBy
    private String operationUserId;

    @CreateByUserName
    private String operationUserName;

    @CreateDate
    private Date operationDate;

    private Integer isDeleted = 0;

    private String logType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent == null ? null : operationContent.trim();
    }

    public String getOperationIp() {
        return operationIp;
    }

    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp == null ? null : operationIp.trim();
    }

    public String getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(String operationUserId) {
        this.operationUserId = operationUserId == null ? null : operationUserId.trim();
    }

    public String getOperationUserName() {
        return operationUserName;
    }

    public void setOperationUserName(String operationUserName) {
        this.operationUserName = operationUserName == null ? null : operationUserName.trim();
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getOperationMethod() {
        return operationMethod;
    }

    public void setOperationMethod(String operationMethod) {
        this.operationMethod = operationMethod;
    }
}

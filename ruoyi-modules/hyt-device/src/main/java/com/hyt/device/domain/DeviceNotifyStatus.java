package com.hyt.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 device_notify_status
 * 
 * @author chy
 * @date 2023-03-01
 */
public class DeviceNotifyStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String notifyId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deviceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date notifyTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date getTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date confirmTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNotifyId(String notifyId) 
    {
        this.notifyId = notifyId;
    }

    public String getNotifyId() 
    {
        return notifyId;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setNotifyTime(Date notifyTime) 
    {
        this.notifyTime = notifyTime;
    }

    public Date getNotifyTime() 
    {
        return notifyTime;
    }
    public void setGetTime(Date getTime) 
    {
        this.getTime = getTime;
    }

    public Date getGetTime() 
    {
        return getTime;
    }
    public void setConfirmTime(Date confirmTime) 
    {
        this.confirmTime = confirmTime;
    }

    public Date getConfirmTime() 
    {
        return confirmTime;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("notifyId", getNotifyId())
            .append("deviceId", getDeviceId())
            .append("type", getType())
            .append("content", getContent())
            .append("notifyTime", getNotifyTime())
            .append("getTime", getGetTime())
            .append("confirmTime", getConfirmTime())
            .append("status", getStatus())
            .toString();
    }
}

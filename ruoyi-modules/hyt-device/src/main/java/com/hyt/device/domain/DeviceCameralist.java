package com.hyt.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 device_cameraList
 * 
 * @author chy
 * @date 2023-02-24
 */
public class DeviceCameralist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deviceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String cameraList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long currentTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date showDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setCameraList(String cameraList) 
    {
        this.cameraList = cameraList;
    }

    public String getCameraList() 
    {
        return cameraList;
    }
    public void setCurrentTime(Long currentTime) 
    {
        this.currentTime = currentTime;
    }

    public Long getCurrentTime() 
    {
        return currentTime;
    }
    public void setShowDate(Date showDate) 
    {
        this.showDate = showDate;
    }

    public Date getShowDate() 
    {
        return showDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("cameraList", getCameraList())
            .append("currentTime", getCurrentTime())
            .append("showDate", getShowDate())
            .toString();
    }
}
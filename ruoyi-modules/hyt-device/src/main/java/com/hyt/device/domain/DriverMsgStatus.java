package com.hyt.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 driver_msg_status
 * 
 * @author chy
 * @date 2023-03-01
 */
public class DriverMsgStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String contentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String driverId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date readTime;

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
    public void setContentId(String contentId) 
    {
        this.contentId = contentId;
    }

    public String getContentId() 
    {
        return contentId;
    }
    public void setDriverId(String driverId) 
    {
        this.driverId = driverId;
    }

    public String getDriverId() 
    {
        return driverId;
    }
    public void setReadTime(Date readTime) 
    {
        this.readTime = readTime;
    }

    public Date getReadTime() 
    {
        return readTime;
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
            .append("contentId", getContentId())
            .append("driverId", getDriverId())
            .append("readTime", getReadTime())
            .append("status", getStatus())
            .toString();
    }
}

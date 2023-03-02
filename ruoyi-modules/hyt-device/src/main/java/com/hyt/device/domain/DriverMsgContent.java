package com.hyt.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 driver_msg_content
 * 
 * @author chy
 * @date 2023-03-01
 */
public class DriverMsgContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String contentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date publishTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date expiredTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String publisherId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }
    public void setExpiredTime(Date expiredTime) 
    {
        this.expiredTime = expiredTime;
    }

    public Date getExpiredTime() 
    {
        return expiredTime;
    }
    public void setPublisherId(String publisherId) 
    {
        this.publisherId = publisherId;
    }

    public String getPublisherId() 
    {
        return publisherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contentId", getContentId())
            .append("content", getContent())
            .append("publishTime", getPublishTime())
            .append("expiredTime", getExpiredTime())
            .append("publisherId", getPublisherId())
            .toString();
    }
}

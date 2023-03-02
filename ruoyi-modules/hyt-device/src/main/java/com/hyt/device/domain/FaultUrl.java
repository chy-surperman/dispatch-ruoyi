package com.hyt.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 faultUrl
 * 
 * @author chy
 * @date 2023-03-01
 */
public class FaultUrl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer vehicleId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String routeName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer driverId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String selfNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String url;

    /** 未处理 */
    @Excel(name = "未处理")
    private String description;

    /** 未安装状态 */
    @Excel(name = "未安装状态")
    private Integer status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String maintainDescription;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintainTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String maintainer;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String consuming;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String phone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVehicleId(Integer vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public Integer getVehicleId() 
    {
        return vehicleId;
    }
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setDriverId(Integer driverId) 
    {
        this.driverId = driverId;
    }

    public Integer getDriverId() 
    {
        return driverId;
    }
    public void setReportTime(Date reportTime) 
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime() 
    {
        return reportTime;
    }
    public void setSelfNum(String selfNum) 
    {
        this.selfNum = selfNum;
    }

    public String getSelfNum() 
    {
        return selfNum;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setMaintainDescription(String maintainDescription) 
    {
        this.maintainDescription = maintainDescription;
    }

    public String getMaintainDescription() 
    {
        return maintainDescription;
    }
    public void setMaintainTime(Date maintainTime) 
    {
        this.maintainTime = maintainTime;
    }

    public Date getMaintainTime() 
    {
        return maintainTime;
    }
    public void setMaintainer(String maintainer) 
    {
        this.maintainer = maintainer;
    }

    public String getMaintainer() 
    {
        return maintainer;
    }
    public void setConsuming(String consuming) 
    {
        this.consuming = consuming;
    }

    public String getConsuming() 
    {
        return consuming;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vehicleId", getVehicleId())
            .append("routeName", getRouteName())
            .append("driverId", getDriverId())
            .append("reportTime", getReportTime())
            .append("selfNum", getSelfNum())
            .append("type", getType())
            .append("url", getUrl())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("maintainDescription", getMaintainDescription())
            .append("maintainTime", getMaintainTime())
            .append("maintainer", getMaintainer())
            .append("consuming", getConsuming())
            .append("phone", getPhone())
            .toString();
    }
}

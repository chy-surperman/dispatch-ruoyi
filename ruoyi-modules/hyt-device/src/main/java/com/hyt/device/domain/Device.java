package com.hyt.device.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 device
 * 
 * @author chy
 * @date 2023-02-24
 */
public class Device extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车辆Id */
    @Excel(name = "车辆Id")
    private Long vehicleId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String plateNum;

    /** 自编号 */
    @Excel(name = "自编号")
    private String selfNum;

    /** 线路名称 */
    @Excel(name = "线路名称")
    private String routeName;

    /** 设备Id */
    @Excel(name = "设备Id")
    private String deviceId;

    /** 设备屏幕亮度 */
    @Excel(name = "设备屏幕亮度")
    private Long screenBrightness;

    /** GPS是否用于调度系统(0不使用，1使用) */
    @Excel(name = "GPS是否用于调度系统(0不使用，1使用)")
    private Integer isUseGpsDispatch;

    /** 设备音量 */
    @Excel(name = "设备音量")
    private Long volume;

    /** 旧设备Id */
    @Excel(name = "旧设备Id")
    private String oldDeviceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String newDeviceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal reportVersion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal currentDeviceVersion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal lastVersion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deviceImei;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String iccid;

    /** 设备时间相对当前时间的偏差 */
    @Excel(name = "设备时间相对当前时间的偏差")
    private Long timeDiff;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gpsStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String siteUploadStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String company;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVehicleId(Long vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleId() 
    {
        return vehicleId;
    }
    public void setPlateNum(String plateNum) 
    {
        this.plateNum = plateNum;
    }

    public String getPlateNum() 
    {
        return plateNum;
    }
    public void setSelfNum(String selfNum) 
    {
        this.selfNum = selfNum;
    }

    public String getSelfNum() 
    {
        return selfNum;
    }
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setScreenBrightness(Long screenBrightness) 
    {
        this.screenBrightness = screenBrightness;
    }

    public Long getScreenBrightness() 
    {
        return screenBrightness;
    }
    public void setIsUseGpsDispatch(Integer isUseGpsDispatch) 
    {
        this.isUseGpsDispatch = isUseGpsDispatch;
    }

    public Integer getIsUseGpsDispatch() 
    {
        return isUseGpsDispatch;
    }
    public void setVolume(Long volume) 
    {
        this.volume = volume;
    }

    public Long getVolume() 
    {
        return volume;
    }
    public void setOldDeviceId(String oldDeviceId) 
    {
        this.oldDeviceId = oldDeviceId;
    }

    public String getOldDeviceId() 
    {
        return oldDeviceId;
    }
    public void setNewDeviceId(String newDeviceId) 
    {
        this.newDeviceId = newDeviceId;
    }

    public String getNewDeviceId() 
    {
        return newDeviceId;
    }
    public void setReportVersion(BigDecimal reportVersion) 
    {
        this.reportVersion = reportVersion;
    }

    public BigDecimal getReportVersion() 
    {
        return reportVersion;
    }
    public void setCurrentDeviceVersion(BigDecimal currentDeviceVersion) 
    {
        this.currentDeviceVersion = currentDeviceVersion;
    }

    public BigDecimal getCurrentDeviceVersion() 
    {
        return currentDeviceVersion;
    }
    public void setLastVersion(BigDecimal lastVersion) 
    {
        this.lastVersion = lastVersion;
    }

    public BigDecimal getLastVersion() 
    {
        return lastVersion;
    }
    public void setDeviceImei(String deviceImei) 
    {
        this.deviceImei = deviceImei;
    }

    public String getDeviceImei() 
    {
        return deviceImei;
    }
    public void setIccid(String iccid) 
    {
        this.iccid = iccid;
    }

    public String getIccid() 
    {
        return iccid;
    }
    public void setTimeDiff(Long timeDiff) 
    {
        this.timeDiff = timeDiff;
    }

    public Long getTimeDiff() 
    {
        return timeDiff;
    }
    public void setGpsStatus(String gpsStatus) 
    {
        this.gpsStatus = gpsStatus;
    }

    public String getGpsStatus() 
    {
        return gpsStatus;
    }
    public void setSiteUploadStatus(String siteUploadStatus) 
    {
        this.siteUploadStatus = siteUploadStatus;
    }

    public String getSiteUploadStatus() 
    {
        return siteUploadStatus;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vehicleId", getVehicleId())
            .append("plateNum", getPlateNum())
            .append("selfNum", getSelfNum())
            .append("routeName", getRouteName())
            .append("deviceId", getDeviceId())
            .append("screenBrightness", getScreenBrightness())
            .append("isUseGpsDispatch", getIsUseGpsDispatch())
            .append("volume", getVolume())
            .append("oldDeviceId", getOldDeviceId())
            .append("newDeviceId", getNewDeviceId())
            .append("reportVersion", getReportVersion())
            .append("currentDeviceVersion", getCurrentDeviceVersion())
            .append("lastVersion", getLastVersion())
            .append("deviceImei", getDeviceImei())
            .append("iccid", getIccid())
            .append("timeDiff", getTimeDiff())
            .append("gpsStatus", getGpsStatus())
            .append("siteUploadStatus", getSiteUploadStatus())
            .append("company", getCompany())
            .toString();
    }
}

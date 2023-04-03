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
    private Long[] ids;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public String getDeviceId() {
        return deviceId;
    }

    /** $column.columnComment */
    @Excel(name = "设备编号", readConverterExp = "$column.readConverterExp()")
    private String deviceId;

    /** $column.columnComment */
    @Excel(name = "摄像头编号", readConverterExp = "$column.readConverterExp()")
    private String cameraList;

    /** $column.columnComment */
    @Excel(name = "当前时间戳", readConverterExp = "$column.readConverterExp()")
    private Long currentTime;

    /** $column.columnComment */
    @Excel(name = "当前时间", readConverterExp = "$column.readConverterExp()")
    private Date showDate;

    @Excel(name = "公司名称", readConverterExp = "$column.readConverterExp()")
    private String company;
    @Excel(name = "线路名称", readConverterExp = "$column.readConverterExp()")
    private String routeName;
    @Excel(name = "自编号", readConverterExp = "$column.readConverterExp()")
    private String selfNum;
    @Excel(name = "车牌号", readConverterExp = "$column.readConverterExp()")
    private String plateNum;
    @Excel(name = "ICCID", readConverterExp = "$column.readConverterExp()")
    private String iccid;
    @Excel(name = "当前版本", readConverterExp = "$column.readConverterExp()")
    private String currentDeviceVersion;
    @Excel(name = "屏幕亮度", readConverterExp = "$column.readConverterExp()")
    private String screenBrightness;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getSelfNum() {
        return selfNum;
    }

    public void setSelfNum(String selfNum) {
        this.selfNum = selfNum;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCurrentDeviceVersion() {
        return currentDeviceVersion;
    }

    public void setCurrentDeviceVersion(String currentDeviceVersion) {
        this.currentDeviceVersion = currentDeviceVersion;
    }

    public String getScreenBrightness() {
        return screenBrightness;
    }

    public void setScreenBrightness(String screenBrightness) {
        this.screenBrightness = screenBrightness;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    private String volume;



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

    public String getCameraList() {
        return cameraList;
    }

    public void setCameraList(String cameraList) {
        this.cameraList = cameraList;
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
        return "DeviceCameralist{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", cameraList='" + cameraList + '\'' +
                ", currentTime=" + currentTime +
                ", showDate=" + showDate +
                ", company='" + company + '\'' +
                ", routeName='" + routeName + '\'' +
                ", selfNum='" + selfNum + '\'' +
                ", plateNum='" + plateNum + '\'' +
                ", iccid='" + iccid + '\'' +
                ", currentDeviceVersion='" + currentDeviceVersion + '\'' +
                ", screenBrightness='" + screenBrightness + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}

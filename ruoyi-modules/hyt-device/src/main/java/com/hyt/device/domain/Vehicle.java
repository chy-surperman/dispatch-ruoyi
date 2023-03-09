package com.hyt.device.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 vehicle
 * 
 * @author chy
 * @date 2023-03-09
 */
public class Vehicle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String vehicleId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String plateNum;

    /** 车牌颜色(1蓝色,2黄色,3黑色,4白色,9其它) */
    @Excel(name = "车牌颜色(1蓝色,2黄色,3黑色,4白色,9其它)")
    private Integer plateColor;

    /** 线路名称 */
    @Excel(name = "线路名称")
    private String routeName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String starttag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String driverId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String driverName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long heartTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String network;

    /** 油补平台绑定终端 */
    @Excel(name = "油补平台绑定终端")
    private String terminal;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String selfNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long config;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long restart;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long vehicleFlag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long rebootFlag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long reportConfig;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long reportNetwork;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long workStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String version;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long versionCode;

    /** 车辆运行状态（1、上行运行，2、上下车场，3、下行运行，4、下行车场） */
    @Excel(name = "车辆运行状态", readConverterExp = "1=、上行运行，2、上下车场，3、下行运行，4、下行车场")
    private String runningStatus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date arrivalTime;

    /** 车钥匙卡编号 */
    @Excel(name = "车钥匙卡编号")
    private String swipeCode;

    /** 是否支持油补平台(1，支持，0不支持) */
    @Excel(name = "是否支持油补平台(1，支持，0不支持)")
    private Integer isSupportOilPlatform;

    /** 是否支持海信平台（1，支持，0不支持） */
    @Excel(name = "是否支持海信平台", readConverterExp = "1=，支持，0不支持")
    private Integer isSupportHxplatform;

    /** 是否支持长沙县平台（1、支持，0不支持） */
    @Excel(name = "是否支持长沙县平台", readConverterExp = "1=、支持，0不支持")
    private Integer isSupportCsxplatform;

    /** 海信平台终端编号 */
    @Excel(name = "海信平台终端编号")
    private String hxDeviceId;

    /** 油补平台车辆所属公司 */
    @Excel(name = "油补平台车辆所属公司")
    private String reportOilCompany;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVehicleId(String vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() 
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
    public void setPlateColor(Integer plateColor) 
    {
        this.plateColor = plateColor;
    }

    public Integer getPlateColor() 
    {
        return plateColor;
    }
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setStarttag(String starttag) 
    {
        this.starttag = starttag;
    }

    public String getStarttag() 
    {
        return starttag;
    }
    public void setDriverId(String driverId) 
    {
        this.driverId = driverId;
    }

    public String getDriverId() 
    {
        return driverId;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setHeartTime(Long heartTime) 
    {
        this.heartTime = heartTime;
    }

    public Long getHeartTime() 
    {
        return heartTime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setNetwork(String network) 
    {
        this.network = network;
    }

    public String getNetwork() 
    {
        return network;
    }
    public void setTerminal(String terminal) 
    {
        this.terminal = terminal;
    }

    public String getTerminal() 
    {
        return terminal;
    }
    public void setSelfNum(String selfNum) 
    {
        this.selfNum = selfNum;
    }

    public String getSelfNum() 
    {
        return selfNum;
    }
    public void setConfig(Long config) 
    {
        this.config = config;
    }

    public Long getConfig() 
    {
        return config;
    }
    public void setRestart(Long restart) 
    {
        this.restart = restart;
    }

    public Long getRestart() 
    {
        return restart;
    }
    public void setVehicleFlag(Long vehicleFlag) 
    {
        this.vehicleFlag = vehicleFlag;
    }

    public Long getVehicleFlag() 
    {
        return vehicleFlag;
    }
    public void setRebootFlag(Long rebootFlag) 
    {
        this.rebootFlag = rebootFlag;
    }

    public Long getRebootFlag() 
    {
        return rebootFlag;
    }
    public void setReportConfig(Long reportConfig) 
    {
        this.reportConfig = reportConfig;
    }

    public Long getReportConfig() 
    {
        return reportConfig;
    }
    public void setReportNetwork(Long reportNetwork) 
    {
        this.reportNetwork = reportNetwork;
    }

    public Long getReportNetwork() 
    {
        return reportNetwork;
    }
    public void setWorkStatus(Long workStatus) 
    {
        this.workStatus = workStatus;
    }

    public Long getWorkStatus() 
    {
        return workStatus;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setVersionCode(Long versionCode) 
    {
        this.versionCode = versionCode;
    }

    public Long getVersionCode() 
    {
        return versionCode;
    }
    public void setRunningStatus(String runningStatus) 
    {
        this.runningStatus = runningStatus;
    }

    public String getRunningStatus() 
    {
        return runningStatus;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setSwipeCode(String swipeCode) 
    {
        this.swipeCode = swipeCode;
    }

    public String getSwipeCode() 
    {
        return swipeCode;
    }
    public void setIsSupportOilPlatform(Integer isSupportOilPlatform) 
    {
        this.isSupportOilPlatform = isSupportOilPlatform;
    }

    public Integer getIsSupportOilPlatform() 
    {
        return isSupportOilPlatform;
    }
    public void setIsSupportHxplatform(Integer isSupportHxplatform) 
    {
        this.isSupportHxplatform = isSupportHxplatform;
    }

    public Integer getIsSupportHxplatform() 
    {
        return isSupportHxplatform;
    }
    public void setIsSupportCsxplatform(Integer isSupportCsxplatform) 
    {
        this.isSupportCsxplatform = isSupportCsxplatform;
    }

    public Integer getIsSupportCsxplatform() 
    {
        return isSupportCsxplatform;
    }
    public void setHxDeviceId(String hxDeviceId) 
    {
        this.hxDeviceId = hxDeviceId;
    }

    public String getHxDeviceId() 
    {
        return hxDeviceId;
    }
    public void setReportOilCompany(String reportOilCompany) 
    {
        this.reportOilCompany = reportOilCompany;
    }

    public String getReportOilCompany() 
    {
        return reportOilCompany;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vehicleId", getVehicleId())
            .append("plateNum", getPlateNum())
            .append("plateColor", getPlateColor())
            .append("routeName", getRouteName())
            .append("starttag", getStarttag())
            .append("driverId", getDriverId())
            .append("driverName", getDriverName())
            .append("heartTime", getHeartTime())
            .append("status", getStatus())
            .append("network", getNetwork())
            .append("terminal", getTerminal())
            .append("selfNum", getSelfNum())
            .append("config", getConfig())
            .append("restart", getRestart())
            .append("vehicleFlag", getVehicleFlag())
            .append("rebootFlag", getRebootFlag())
            .append("reportConfig", getReportConfig())
            .append("reportNetwork", getReportNetwork())
            .append("workStatus", getWorkStatus())
            .append("version", getVersion())
            .append("versionCode", getVersionCode())
            .append("runningStatus", getRunningStatus())
            .append("arrivalTime", getArrivalTime())
            .append("swipeCode", getSwipeCode())
            .append("isSupportOilPlatform", getIsSupportOilPlatform())
            .append("isSupportHxplatform", getIsSupportHxplatform())
            .append("isSupportCsxplatform", getIsSupportCsxplatform())
            .append("hxDeviceId", getHxDeviceId())
            .append("reportOilCompany", getReportOilCompany())
            .toString();
    }
}

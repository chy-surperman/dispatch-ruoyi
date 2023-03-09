package com.hyt.device.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 device_route_site
 * 
 * @author chy
 * @date 2023-03-01
 */
public class DeviceRouteSite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 站点Id */
    @Excel(name = "站点Id")
    private String siteId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String starttag;

    /** 站点名称 */
    @Excel(name = "站点名称")
    private String siteName;

    /** 线路 */
    @Excel(name = "线路")
    private String routeName;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal latitude;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long direction;

    /** 进站经度 */
    @Excel(name = "进站经度")
    private BigDecimal inLongitude;

    /** 进站纬度 */
    @Excel(name = "进站纬度")
    private BigDecimal inLatitude;

    /** 进站距离 */
    @Excel(name = "进站距离")
    private Long inDistance;

    /** 出站经度 */
    @Excel(name = "出站经度")
    private BigDecimal outLongitude;

    /** 出站纬度 */
    @Excel(name = "出站纬度")
    private BigDecimal outLatitude;

    /** 出站距离 */
    @Excel(name = "出站距离")
    private Long outDistance;

    /** 与线路起始点距离 */
    @Excel(name = "与线路起始点距离")
    private Long distance;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer index;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSiteId(String siteId) 
    {
        this.siteId = siteId;
    }

    public String getSiteId() 
    {
        return siteId;
    }
    public void setStarttag(String starttag) 
    {
        this.starttag = starttag;
    }

    public String getStarttag() 
    {
        return starttag;
    }
    public void setSiteName(String siteName) 
    {
        this.siteName = siteName;
    }

    public String getSiteName() 
    {
        return siteName;
    }
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setLongitude(BigDecimal longitude) 
    {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(BigDecimal latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() 
    {
        return latitude;
    }
    public void setDirection(Long direction) 
    {
        this.direction = direction;
    }

    public Long getDirection() 
    {
        return direction;
    }
    public void setInLongitude(BigDecimal inLongitude) 
    {
        this.inLongitude = inLongitude;
    }

    public BigDecimal getInLongitude() 
    {
        return inLongitude;
    }
    public void setInLatitude(BigDecimal inLatitude) 
    {
        this.inLatitude = inLatitude;
    }

    public BigDecimal getInLatitude() 
    {
        return inLatitude;
    }
    public void setInDistance(Long inDistance) 
    {
        this.inDistance = inDistance;
    }

    public Long getInDistance() 
    {
        return inDistance;
    }
    public void setOutLongitude(BigDecimal outLongitude) 
    {
        this.outLongitude = outLongitude;
    }

    public BigDecimal getOutLongitude() 
    {
        return outLongitude;
    }
    public void setOutLatitude(BigDecimal outLatitude) 
    {
        this.outLatitude = outLatitude;
    }

    public BigDecimal getOutLatitude() 
    {
        return outLatitude;
    }
    public void setOutDistance(Long outDistance) 
    {
        this.outDistance = outDistance;
    }

    public Long getOutDistance() 
    {
        return outDistance;
    }
    public void setDistance(Long distance) 
    {
        this.distance = distance;
    }

    public Long getDistance() 
    {
        return distance;
    }
    public void setIndex(Integer index) 
    {
        this.index = index;
    }

    public Integer getIndex() 
    {
        return index;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("siteId", getSiteId())
            .append("starttag", getStarttag())
            .append("siteName", getSiteName())
            .append("routeName", getRouteName())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("direction", getDirection())
            .append("inLongitude", getInLongitude())
            .append("inLatitude", getInLatitude())
            .append("inDistance", getInDistance())
            .append("outLongitude", getOutLongitude())
            .append("outLatitude", getOutLatitude())
            .append("outDistance", getOutDistance())
            .append("distance", getDistance())
            .append("index", getIndex())
            .toString();
    }
}

package com.hyt.device.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 device_route_site_voice
 * 
 * @author chy
 * @date 2023-03-01
 */
public class DeviceRouteSiteVoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String routeName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String siteId;

    /** 进站语音 */
    @Excel(name = "进站语音")
    private String inSiteVoice;

    /** 到站语音 */
    @Excel(name = "到站语音")
    private String siteVoice;

    /** 出站语音 */
    @Excel(name = "出站语音")
    private String outSiteVoice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String adVoice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tipsVoice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setSiteId(String siteId) 
    {
        this.siteId = siteId;
    }

    public String getSiteId() 
    {
        return siteId;
    }
    public void setInSiteVoice(String inSiteVoice) 
    {
        this.inSiteVoice = inSiteVoice;
    }

    public String getInSiteVoice() 
    {
        return inSiteVoice;
    }
    public void setSiteVoice(String siteVoice) 
    {
        this.siteVoice = siteVoice;
    }

    public String getSiteVoice() 
    {
        return siteVoice;
    }
    public void setOutSiteVoice(String outSiteVoice) 
    {
        this.outSiteVoice = outSiteVoice;
    }

    public String getOutSiteVoice() 
    {
        return outSiteVoice;
    }
    public void setAdVoice(String adVoice) 
    {
        this.adVoice = adVoice;
    }

    public String getAdVoice() 
    {
        return adVoice;
    }
    public void setTipsVoice(String tipsVoice) 
    {
        this.tipsVoice = tipsVoice;
    }

    public String getTipsVoice() 
    {
        return tipsVoice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("routeName", getRouteName())
            .append("siteId", getSiteId())
            .append("inSiteVoice", getInSiteVoice())
            .append("siteVoice", getSiteVoice())
            .append("outSiteVoice", getOutSiteVoice())
            .append("adVoice", getAdVoice())
            .append("tipsVoice", getTipsVoice())
            .toString();
    }
}

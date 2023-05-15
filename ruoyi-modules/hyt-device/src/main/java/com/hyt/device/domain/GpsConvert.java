package com.hyt.device.domain;

import com.ruoyi.common.core.annotation.Excel;
import lombok.Data;

/**
 * <b><code>GpsConvert</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/5/15 10:18.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
@Data
public class GpsConvert {

  @Excel(name = "站点顺序")
  private String sequence;
  @Excel(name = "线路")
  private String routeName;
  @Excel(name = "方向(上行/下行)")
  private String starttag;
  @Excel(name = "站点名称")
  private String siteName;
  @Excel(name = "精度")
  private String latitude;
  @Excel(name = "纬度")
  private String longitude;

}

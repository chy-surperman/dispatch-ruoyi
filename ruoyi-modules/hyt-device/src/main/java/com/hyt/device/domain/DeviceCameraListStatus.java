package com.hyt.device.domain;

import com.ruoyi.common.core.annotation.Excel;
import lombok.Data;

/**
 * @Description:
 * @Auther: Chy$
 */
@Data
public class DeviceCameraListStatus {
    @Excel(name = "公司名称")
    private String company;
    @Excel(name = "线路名称")
    private String routeName;
    @Excel(name = "自编号")
    private String selfNum;
    @Excel(name = "车牌号")
    private String plateNum;
    @Excel(name = "设备编号")
    private String deviceId;
    @Excel(name = "摄像头编号")
    private String cameraId;
    @Excel(name = "有录像次数")
    private int have;
    @Excel(name = "无录像次数")
    private int notHave;
    @Excel(name = "总计录像次数")
    private int total;

}

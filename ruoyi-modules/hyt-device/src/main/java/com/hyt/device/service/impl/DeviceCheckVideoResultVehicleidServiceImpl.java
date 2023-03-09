package com.hyt.device.service.impl;

import java.util.List;

import com.hyt.device.domain.DeviceCameraListStatus;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceCheckVideoResultVehicleidMapper;
import com.hyt.device.domain.DeviceCheckVideoResultVehicleid;
import com.hyt.device.service.IDeviceCheckVideoResultVehicleidService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DeviceCheckVideoResultVehicleidServiceImpl implements IDeviceCheckVideoResultVehicleidService 
{
    @Autowired
    private DeviceCheckVideoResultVehicleidMapper deviceCheckVideoResultVehicleidMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceCheckVideoResultVehicleid selectDeviceCheckVideoResultVehicleidById(Long id)
    {
        return deviceCheckVideoResultVehicleidMapper.selectDeviceCheckVideoResultVehicleidById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceCheckVideoResultVehicleid 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceCheckVideoResultVehicleid> selectDeviceCheckVideoResultVehicleidList(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        return deviceCheckVideoResultVehicleidMapper.selectDeviceCheckVideoResultVehicleidList(deviceCheckVideoResultVehicleid);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceCheckVideoResultVehicleid 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceCheckVideoResultVehicleid(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        deviceCheckVideoResultVehicleid.setCreateTime(DateUtils.getNowDate());
        return deviceCheckVideoResultVehicleidMapper.insertDeviceCheckVideoResultVehicleid(deviceCheckVideoResultVehicleid);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceCheckVideoResultVehicleid 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceCheckVideoResultVehicleid(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        return deviceCheckVideoResultVehicleidMapper.updateDeviceCheckVideoResultVehicleid(deviceCheckVideoResultVehicleid);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceCheckVideoResultVehicleidByIds(Long[] ids)
    {
        return deviceCheckVideoResultVehicleidMapper.deleteDeviceCheckVideoResultVehicleidByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceCheckVideoResultVehicleidById(Long id)
    {
        return deviceCheckVideoResultVehicleidMapper.deleteDeviceCheckVideoResultVehicleidById(id);
    }

    @Override
    public List<DeviceCameraListStatus> getDeviceCameraListStatus(String workdate) {
       String startTime=workdate+" 00:00:00";
       String endTime=workdate+" 23:59:59";
        return deviceCheckVideoResultVehicleidMapper.getDeviceCameraListStatus(startTime,endTime);
    }
}

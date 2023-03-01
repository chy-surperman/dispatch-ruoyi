package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceNotifyStatusMapper;
import com.hyt.device.domain.DeviceNotifyStatus;
import com.hyt.device.service.IDeviceNotifyStatusService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DeviceNotifyStatusServiceImpl implements IDeviceNotifyStatusService 
{
    @Autowired
    private DeviceNotifyStatusMapper deviceNotifyStatusMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceNotifyStatus selectDeviceNotifyStatusById(Long id)
    {
        return deviceNotifyStatusMapper.selectDeviceNotifyStatusById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceNotifyStatus 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceNotifyStatus> selectDeviceNotifyStatusList(DeviceNotifyStatus deviceNotifyStatus)
    {
        return deviceNotifyStatusMapper.selectDeviceNotifyStatusList(deviceNotifyStatus);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceNotifyStatus 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceNotifyStatus(DeviceNotifyStatus deviceNotifyStatus)
    {
        return deviceNotifyStatusMapper.insertDeviceNotifyStatus(deviceNotifyStatus);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceNotifyStatus 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceNotifyStatus(DeviceNotifyStatus deviceNotifyStatus)
    {
        return deviceNotifyStatusMapper.updateDeviceNotifyStatus(deviceNotifyStatus);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceNotifyStatusByIds(Long[] ids)
    {
        return deviceNotifyStatusMapper.deleteDeviceNotifyStatusByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceNotifyStatusById(Long id)
    {
        return deviceNotifyStatusMapper.deleteDeviceNotifyStatusById(id);
    }
}

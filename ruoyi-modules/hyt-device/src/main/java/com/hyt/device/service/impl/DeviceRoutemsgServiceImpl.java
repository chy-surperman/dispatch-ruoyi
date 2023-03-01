package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceRoutemsgMapper;
import com.hyt.device.domain.DeviceRoutemsg;
import com.hyt.device.service.IDeviceRoutemsgService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DeviceRoutemsgServiceImpl implements IDeviceRoutemsgService 
{
    @Autowired
    private DeviceRoutemsgMapper deviceRoutemsgMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceRoutemsg selectDeviceRoutemsgById(Long id)
    {
        return deviceRoutemsgMapper.selectDeviceRoutemsgById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceRoutemsg 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceRoutemsg> selectDeviceRoutemsgList(DeviceRoutemsg deviceRoutemsg)
    {
        return deviceRoutemsgMapper.selectDeviceRoutemsgList(deviceRoutemsg);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceRoutemsg 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceRoutemsg(DeviceRoutemsg deviceRoutemsg)
    {
        return deviceRoutemsgMapper.insertDeviceRoutemsg(deviceRoutemsg);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceRoutemsg 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceRoutemsg(DeviceRoutemsg deviceRoutemsg)
    {
        return deviceRoutemsgMapper.updateDeviceRoutemsg(deviceRoutemsg);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceRoutemsgByIds(Long[] ids)
    {
        return deviceRoutemsgMapper.deleteDeviceRoutemsgByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceRoutemsgById(Long id)
    {
        return deviceRoutemsgMapper.deleteDeviceRoutemsgById(id);
    }
}

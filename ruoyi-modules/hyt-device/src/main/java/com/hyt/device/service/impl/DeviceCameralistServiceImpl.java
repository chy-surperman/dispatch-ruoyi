package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceCameralistMapper;
import com.hyt.device.domain.DeviceCameralist;
import com.hyt.device.service.IDeviceCameralistService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-02-24
 */
@Service
public class DeviceCameralistServiceImpl implements IDeviceCameralistService 
{
    @Autowired
    private DeviceCameralistMapper deviceCameralistMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceCameralist selectDeviceCameralistById(Long id)
    {
        return deviceCameralistMapper.selectDeviceCameralistById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceCameralist 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceCameralist> selectDeviceCameralistList(DeviceCameralist deviceCameralist)
    {
        return deviceCameralistMapper.selectDeviceCameralistList(deviceCameralist);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceCameralist 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceCameralist(DeviceCameralist deviceCameralist)
    {
        return deviceCameralistMapper.insertDeviceCameralist(deviceCameralist);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceCameralist 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceCameralist(DeviceCameralist deviceCameralist)
    {
        return deviceCameralistMapper.updateDeviceCameralist(deviceCameralist);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceCameralistByIds(Long[] ids)
    {
        return deviceCameralistMapper.deleteDeviceCameralistByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceCameralistById(Long id)
    {
        return deviceCameralistMapper.deleteDeviceCameralistById(id);
    }
}
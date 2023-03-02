package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceMaintainInfoMapper;
import com.hyt.device.domain.DeviceMaintainInfo;
import com.hyt.device.service.IDeviceMaintainInfoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DeviceMaintainInfoServiceImpl implements IDeviceMaintainInfoService 
{
    @Autowired
    private DeviceMaintainInfoMapper deviceMaintainInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceMaintainInfo selectDeviceMaintainInfoById(Long id)
    {
        return deviceMaintainInfoMapper.selectDeviceMaintainInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceMaintainInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceMaintainInfo> selectDeviceMaintainInfoList(DeviceMaintainInfo deviceMaintainInfo)
    {
        return deviceMaintainInfoMapper.selectDeviceMaintainInfoList(deviceMaintainInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceMaintainInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceMaintainInfo(DeviceMaintainInfo deviceMaintainInfo)
    {
        return deviceMaintainInfoMapper.insertDeviceMaintainInfo(deviceMaintainInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceMaintainInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceMaintainInfo(DeviceMaintainInfo deviceMaintainInfo)
    {
        return deviceMaintainInfoMapper.updateDeviceMaintainInfo(deviceMaintainInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceMaintainInfoByIds(Long[] ids)
    {
        return deviceMaintainInfoMapper.deleteDeviceMaintainInfoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceMaintainInfoById(Long id)
    {
        return deviceMaintainInfoMapper.deleteDeviceMaintainInfoById(id);
    }
}

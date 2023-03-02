package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceRouteSiteMapper;
import com.hyt.device.domain.DeviceRouteSite;
import com.hyt.device.service.IDeviceRouteSiteService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DeviceRouteSiteServiceImpl implements IDeviceRouteSiteService 
{
    @Autowired
    private DeviceRouteSiteMapper deviceRouteSiteMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceRouteSite selectDeviceRouteSiteById(Long id)
    {
        return deviceRouteSiteMapper.selectDeviceRouteSiteById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceRouteSite 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceRouteSite> selectDeviceRouteSiteList(DeviceRouteSite deviceRouteSite)
    {
        return deviceRouteSiteMapper.selectDeviceRouteSiteList(deviceRouteSite);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceRouteSite 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceRouteSite(DeviceRouteSite deviceRouteSite)
    {
        return deviceRouteSiteMapper.insertDeviceRouteSite(deviceRouteSite);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceRouteSite 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceRouteSite(DeviceRouteSite deviceRouteSite)
    {
        return deviceRouteSiteMapper.updateDeviceRouteSite(deviceRouteSite);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceRouteSiteByIds(Long[] ids)
    {
        return deviceRouteSiteMapper.deleteDeviceRouteSiteByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceRouteSiteById(Long id)
    {
        return deviceRouteSiteMapper.deleteDeviceRouteSiteById(id);
    }
}

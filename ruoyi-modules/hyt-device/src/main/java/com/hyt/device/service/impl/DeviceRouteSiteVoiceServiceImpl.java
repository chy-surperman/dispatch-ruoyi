package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceRouteSiteVoiceMapper;
import com.hyt.device.domain.DeviceRouteSiteVoice;
import com.hyt.device.service.IDeviceRouteSiteVoiceService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DeviceRouteSiteVoiceServiceImpl implements IDeviceRouteSiteVoiceService 
{
    @Autowired
    private DeviceRouteSiteVoiceMapper deviceRouteSiteVoiceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DeviceRouteSiteVoice selectDeviceRouteSiteVoiceById(Long id)
    {
        return deviceRouteSiteVoiceMapper.selectDeviceRouteSiteVoiceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceRouteSiteVoice 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DeviceRouteSiteVoice> selectDeviceRouteSiteVoiceList(DeviceRouteSiteVoice deviceRouteSiteVoice)
    {
        return deviceRouteSiteVoiceMapper.selectDeviceRouteSiteVoiceList(deviceRouteSiteVoice);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceRouteSiteVoice 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDeviceRouteSiteVoice(DeviceRouteSiteVoice deviceRouteSiteVoice)
    {
        return deviceRouteSiteVoiceMapper.insertDeviceRouteSiteVoice(deviceRouteSiteVoice);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceRouteSiteVoice 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDeviceRouteSiteVoice(DeviceRouteSiteVoice deviceRouteSiteVoice)
    {
        return deviceRouteSiteVoiceMapper.updateDeviceRouteSiteVoice(deviceRouteSiteVoice);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceRouteSiteVoiceByIds(Long[] ids)
    {
        return deviceRouteSiteVoiceMapper.deleteDeviceRouteSiteVoiceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceRouteSiteVoiceById(Long id)
    {
        return deviceRouteSiteVoiceMapper.deleteDeviceRouteSiteVoiceById(id);
    }
}

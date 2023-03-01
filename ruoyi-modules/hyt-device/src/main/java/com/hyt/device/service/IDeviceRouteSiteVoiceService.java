package com.hyt.device.service;

import java.util.List;
import com.hyt.device.domain.DeviceRouteSiteVoice;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface IDeviceRouteSiteVoiceService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceRouteSiteVoice selectDeviceRouteSiteVoiceById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceRouteSiteVoice 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceRouteSiteVoice> selectDeviceRouteSiteVoiceList(DeviceRouteSiteVoice deviceRouteSiteVoice);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceRouteSiteVoice 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceRouteSiteVoice(DeviceRouteSiteVoice deviceRouteSiteVoice);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceRouteSiteVoice 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceRouteSiteVoice(DeviceRouteSiteVoice deviceRouteSiteVoice);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDeviceRouteSiteVoiceByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceRouteSiteVoiceById(Long id);
}

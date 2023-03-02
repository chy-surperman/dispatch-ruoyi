package com.hyt.device.service;

import java.util.List;
import com.hyt.device.domain.DeviceRoutemsg;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface IDeviceRoutemsgService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceRoutemsg selectDeviceRoutemsgById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceRoutemsg 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceRoutemsg> selectDeviceRoutemsgList(DeviceRoutemsg deviceRoutemsg);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceRoutemsg 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceRoutemsg(DeviceRoutemsg deviceRoutemsg);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceRoutemsg 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceRoutemsg(DeviceRoutemsg deviceRoutemsg);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDeviceRoutemsgByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceRoutemsgById(Long id);
}

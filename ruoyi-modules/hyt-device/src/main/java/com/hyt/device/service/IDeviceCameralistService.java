package com.hyt.device.service;

import java.util.List;
import com.hyt.device.domain.DeviceCameralist;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author chy
 * @date 2023-02-24
 */
public interface IDeviceCameralistService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceCameralist selectDeviceCameralistById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceCameralist 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceCameralist> selectDeviceCameralistList(DeviceCameralist deviceCameralist);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceCameralist 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceCameralist(DeviceCameralist deviceCameralist);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceCameralist 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceCameralist(DeviceCameralist deviceCameralist);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDeviceCameralistByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceCameralistById(Long id);
}

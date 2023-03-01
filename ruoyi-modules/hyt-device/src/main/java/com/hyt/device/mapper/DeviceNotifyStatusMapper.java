package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.DeviceNotifyStatus;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface DeviceNotifyStatusMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceNotifyStatus selectDeviceNotifyStatusById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceNotifyStatus 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceNotifyStatus> selectDeviceNotifyStatusList(DeviceNotifyStatus deviceNotifyStatus);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceNotifyStatus 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceNotifyStatus(DeviceNotifyStatus deviceNotifyStatus);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceNotifyStatus 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceNotifyStatus(DeviceNotifyStatus deviceNotifyStatus);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceNotifyStatusById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceNotifyStatusByIds(Long[] ids);
}

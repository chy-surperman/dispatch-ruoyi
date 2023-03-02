package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.DeviceCheckVideoResultVehicleid;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface DeviceCheckVideoResultVehicleidMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceCheckVideoResultVehicleid selectDeviceCheckVideoResultVehicleidById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceCheckVideoResultVehicleid 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceCheckVideoResultVehicleid> selectDeviceCheckVideoResultVehicleidList(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceCheckVideoResultVehicleid 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceCheckVideoResultVehicleid(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceCheckVideoResultVehicleid 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceCheckVideoResultVehicleid(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceCheckVideoResultVehicleidById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceCheckVideoResultVehicleidByIds(Long[] ids);
}

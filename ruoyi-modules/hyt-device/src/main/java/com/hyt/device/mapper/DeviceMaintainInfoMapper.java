package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.DeviceMaintainInfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface DeviceMaintainInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceMaintainInfo selectDeviceMaintainInfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceMaintainInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceMaintainInfo> selectDeviceMaintainInfoList(DeviceMaintainInfo deviceMaintainInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceMaintainInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceMaintainInfo(DeviceMaintainInfo deviceMaintainInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceMaintainInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceMaintainInfo(DeviceMaintainInfo deviceMaintainInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceMaintainInfoById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceMaintainInfoByIds(Long[] ids);
}

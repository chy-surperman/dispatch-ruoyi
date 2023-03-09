package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.DeviceRouteSite;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface DeviceRouteSiteMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DeviceRouteSite selectDeviceRouteSiteById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param deviceRouteSite 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DeviceRouteSite> selectDeviceRouteSiteList(DeviceRouteSite deviceRouteSite);

    /**
     * 新增【请填写功能名称】
     * 
     * @param deviceRouteSite 【请填写功能名称】
     * @return 结果
     */
    public int insertDeviceRouteSite(DeviceRouteSite deviceRouteSite);

    /**
     * 修改【请填写功能名称】
     * 
     * @param deviceRouteSite 【请填写功能名称】
     * @return 结果
     */
    public int updateDeviceRouteSite(DeviceRouteSite deviceRouteSite);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceRouteSiteById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceRouteSiteByIds(Long[] ids);
}

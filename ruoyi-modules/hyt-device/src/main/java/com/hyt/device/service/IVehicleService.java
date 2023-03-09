package com.hyt.device.service;

import java.util.List;
import com.hyt.device.domain.Vehicle;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author chy
 * @date 2023-03-09
 */
public interface IVehicleService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Vehicle selectVehicleById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param vehicle 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Vehicle> selectVehicleList(Vehicle vehicle);

    /**
     * 新增【请填写功能名称】
     * 
     * @param vehicle 【请填写功能名称】
     * @return 结果
     */
    public int insertVehicle(Vehicle vehicle);

    /**
     * 修改【请填写功能名称】
     * 
     * @param vehicle 【请填写功能名称】
     * @return 结果
     */
    public int updateVehicle(Vehicle vehicle);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteVehicleByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVehicleById(Long id);
}

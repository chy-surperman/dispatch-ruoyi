package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.VehicleMapper;
import com.hyt.device.domain.Vehicle;
import com.hyt.device.service.IVehicleService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-09
 */
@Service
public class VehicleServiceImpl implements IVehicleService 
{
    @Autowired
    private VehicleMapper vehicleMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Vehicle selectVehicleById(Long id)
    {
        return vehicleMapper.selectVehicleById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param vehicle 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Vehicle> selectVehicleList(Vehicle vehicle)
    {
        return vehicleMapper.selectVehicleList(vehicle);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param vehicle 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertVehicle(Vehicle vehicle)
    {
        return vehicleMapper.insertVehicle(vehicle);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param vehicle 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateVehicle(Vehicle vehicle)
    {
        return vehicleMapper.updateVehicle(vehicle);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVehicleByIds(Long[] ids)
    {
        return vehicleMapper.deleteVehicleByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVehicleById(Long id)
    {
        return vehicleMapper.deleteVehicleById(id);
    }
}

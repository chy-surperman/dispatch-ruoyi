package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.Vehicle;
import com.ruoyi.common.datasource.annotation.Slave;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-09
 */
@Slave
public interface VehicleMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Vehicle selectVehicleById(Long id);



    /**
     * 查询【请填写功能名称】
     *
     * @param routeName 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<Vehicle> selectVehicleByRouteName(@Param("routeName") String  routeName);

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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVehicleById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVehicleByIds(Long[] ids);
}

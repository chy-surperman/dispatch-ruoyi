package com.hyt.device.mapper;

import java.util.List;
import java.util.Set;

import com.hyt.device.domain.Device;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author chy
 * @date 2023-02-24
 */
public interface DeviceMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Device selectDeviceById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param device 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Device> selectDeviceList(Device device);








    /**
     * 查询【请填写功能名称】列表
     *
     * @param device 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Device> selectDeviceListAndPageNum(@Param("routeName")String routeName,@Param("selfNum")String selfNum);
    /**
     * 新增【请填写功能名称】
     *
     * @param device 【请填写功能名称】
     * @return 结果
     */
    public int insertDevice(Device device);

    /**
     * 修改【请填写功能名称】
     *
     * @param device 【请填写功能名称】
     * @return 结果
     */
    public int updateDevice(Device device);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDeviceById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceByIds(Long[] ids);

    void selectDeviceList();
}

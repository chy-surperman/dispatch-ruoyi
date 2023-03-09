package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.DriverMsgStatus;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface DriverMsgStatusMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DriverMsgStatus selectDriverMsgStatusById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param driverMsgStatus 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DriverMsgStatus> selectDriverMsgStatusList(DriverMsgStatus driverMsgStatus);

    /**
     * 新增【请填写功能名称】
     * 
     * @param driverMsgStatus 【请填写功能名称】
     * @return 结果
     */
    public int insertDriverMsgStatus(DriverMsgStatus driverMsgStatus);

    /**
     * 修改【请填写功能名称】
     * 
     * @param driverMsgStatus 【请填写功能名称】
     * @return 结果
     */
    public int updateDriverMsgStatus(DriverMsgStatus driverMsgStatus);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDriverMsgStatusById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDriverMsgStatusByIds(Long[] ids);
}

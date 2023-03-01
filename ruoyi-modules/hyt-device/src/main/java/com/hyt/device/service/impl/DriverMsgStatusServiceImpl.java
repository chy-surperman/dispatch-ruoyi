package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DriverMsgStatusMapper;
import com.hyt.device.domain.DriverMsgStatus;
import com.hyt.device.service.IDriverMsgStatusService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DriverMsgStatusServiceImpl implements IDriverMsgStatusService 
{
    @Autowired
    private DriverMsgStatusMapper driverMsgStatusMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DriverMsgStatus selectDriverMsgStatusById(Long id)
    {
        return driverMsgStatusMapper.selectDriverMsgStatusById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param driverMsgStatus 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DriverMsgStatus> selectDriverMsgStatusList(DriverMsgStatus driverMsgStatus)
    {
        return driverMsgStatusMapper.selectDriverMsgStatusList(driverMsgStatus);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param driverMsgStatus 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDriverMsgStatus(DriverMsgStatus driverMsgStatus)
    {
        return driverMsgStatusMapper.insertDriverMsgStatus(driverMsgStatus);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param driverMsgStatus 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDriverMsgStatus(DriverMsgStatus driverMsgStatus)
    {
        return driverMsgStatusMapper.updateDriverMsgStatus(driverMsgStatus);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDriverMsgStatusByIds(Long[] ids)
    {
        return driverMsgStatusMapper.deleteDriverMsgStatusByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDriverMsgStatusById(Long id)
    {
        return driverMsgStatusMapper.deleteDriverMsgStatusById(id);
    }
}

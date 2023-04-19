package com.hyt.device.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DeviceMapper;
import com.hyt.device.domain.Device;
import com.hyt.device.service.IDeviceService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author chy
 * @date 2023-02-24
 */
@Service
public class DeviceServiceImpl implements IDeviceService
{
    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Device selectDeviceById(Long id)
    {
        return deviceMapper.selectDeviceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param device 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Device> selectDeviceList(Device device)
    {
        return deviceMapper.selectDeviceList(device);
    }

    @Override
    public List<Device> selectDeviceListAndParam(String routeName,String selfNum) {
        return deviceMapper.selectDeviceListAndPageNum(routeName, selfNum);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param device 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDevice(Device device)
    {
        return deviceMapper.insertDevice(device);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param device 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDevice(Device device)
    {
        return deviceMapper.updateDevice(device);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceByIds(Long[] ids)
    {
        return deviceMapper.deleteDeviceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDeviceById(Long id)
    {
        return deviceMapper.deleteDeviceById(id);
    }
}

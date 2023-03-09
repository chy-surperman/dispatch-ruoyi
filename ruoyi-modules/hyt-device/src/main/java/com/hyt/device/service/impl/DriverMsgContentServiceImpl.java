package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.DriverMsgContentMapper;
import com.hyt.device.domain.DriverMsgContent;
import com.hyt.device.service.IDriverMsgContentService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class DriverMsgContentServiceImpl implements IDriverMsgContentService 
{
    @Autowired
    private DriverMsgContentMapper driverMsgContentMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public DriverMsgContent selectDriverMsgContentById(Integer id)
    {
        return driverMsgContentMapper.selectDriverMsgContentById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param driverMsgContent 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<DriverMsgContent> selectDriverMsgContentList(DriverMsgContent driverMsgContent)
    {
        return driverMsgContentMapper.selectDriverMsgContentList(driverMsgContent);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param driverMsgContent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDriverMsgContent(DriverMsgContent driverMsgContent)
    {
        return driverMsgContentMapper.insertDriverMsgContent(driverMsgContent);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param driverMsgContent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDriverMsgContent(DriverMsgContent driverMsgContent)
    {
        return driverMsgContentMapper.updateDriverMsgContent(driverMsgContent);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDriverMsgContentByIds(Integer[] ids)
    {
        return driverMsgContentMapper.deleteDriverMsgContentByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteDriverMsgContentById(Integer id)
    {
        return driverMsgContentMapper.deleteDriverMsgContentById(id);
    }
}

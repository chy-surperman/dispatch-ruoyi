package com.hyt.device.service;

import java.util.List;
import com.hyt.device.domain.DriverMsgContent;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface IDriverMsgContentService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public DriverMsgContent selectDriverMsgContentById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param driverMsgContent 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<DriverMsgContent> selectDriverMsgContentList(DriverMsgContent driverMsgContent);

    /**
     * 新增【请填写功能名称】
     * 
     * @param driverMsgContent 【请填写功能名称】
     * @return 结果
     */
    public int insertDriverMsgContent(DriverMsgContent driverMsgContent);

    /**
     * 修改【请填写功能名称】
     * 
     * @param driverMsgContent 【请填写功能名称】
     * @return 结果
     */
    public int updateDriverMsgContent(DriverMsgContent driverMsgContent);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteDriverMsgContentByIds(Integer[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteDriverMsgContentById(Integer id);
}

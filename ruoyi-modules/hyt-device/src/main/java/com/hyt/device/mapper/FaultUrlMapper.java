package com.hyt.device.mapper;

import java.util.List;
import com.hyt.device.domain.FaultUrl;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author chy
 * @date 2023-03-01
 */
public interface FaultUrlMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FaultUrl selectFaultUrlById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param faultUrl 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FaultUrl> selectFaultUrlList(FaultUrl faultUrl);

    /**
     * 新增【请填写功能名称】
     * 
     * @param faultUrl 【请填写功能名称】
     * @return 结果
     */
    public int insertFaultUrl(FaultUrl faultUrl);

    /**
     * 修改【请填写功能名称】
     * 
     * @param faultUrl 【请填写功能名称】
     * @return 结果
     */
    public int updateFaultUrl(FaultUrl faultUrl);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteFaultUrlById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFaultUrlByIds(Long[] ids);
}
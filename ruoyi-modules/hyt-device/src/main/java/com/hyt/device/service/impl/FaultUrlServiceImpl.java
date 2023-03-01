package com.hyt.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hyt.device.mapper.FaultUrlMapper;
import com.hyt.device.domain.FaultUrl;
import com.hyt.device.service.IFaultUrlService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author chy
 * @date 2023-03-01
 */
@Service
public class FaultUrlServiceImpl implements IFaultUrlService 
{
    @Autowired
    private FaultUrlMapper faultUrlMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FaultUrl selectFaultUrlById(Long id)
    {
        return faultUrlMapper.selectFaultUrlById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param faultUrl 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FaultUrl> selectFaultUrlList(FaultUrl faultUrl)
    {
        return faultUrlMapper.selectFaultUrlList(faultUrl);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param faultUrl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertFaultUrl(FaultUrl faultUrl)
    {
        return faultUrlMapper.insertFaultUrl(faultUrl);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param faultUrl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateFaultUrl(FaultUrl faultUrl)
    {
        return faultUrlMapper.updateFaultUrl(faultUrl);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFaultUrlByIds(Long[] ids)
    {
        return faultUrlMapper.deleteFaultUrlByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteFaultUrlById(Long id)
    {
        return faultUrlMapper.deleteFaultUrlById(id);
    }
}

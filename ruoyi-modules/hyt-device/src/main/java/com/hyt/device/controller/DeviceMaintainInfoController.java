package com.hyt.device.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.hyt.device.domain.DeviceMaintainInfo;
import com.hyt.device.service.IDeviceMaintainInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author chy
 * @date 2023-03-01
 */
@Api("维护接口")
@RestController
@RequestMapping("/info")
public class DeviceMaintainInfoController extends BaseController
{
    @Autowired
    private IDeviceMaintainInfoService deviceMaintainInfoService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("device:info:list")
    @GetMapping("/list")
    public TableDataInfo list(DeviceMaintainInfo deviceMaintainInfo)
    {
        startPage();
        List<DeviceMaintainInfo> list = deviceMaintainInfoService.selectDeviceMaintainInfoList(deviceMaintainInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:info:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceMaintainInfo deviceMaintainInfo)
    {
        List<DeviceMaintainInfo> list = deviceMaintainInfoService.selectDeviceMaintainInfoList(deviceMaintainInfo);
        ExcelUtil<DeviceMaintainInfo> util = new ExcelUtil<DeviceMaintainInfo>(DeviceMaintainInfo.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:info:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceMaintainInfoService.selectDeviceMaintainInfoById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:info:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceMaintainInfo deviceMaintainInfo)
    {
        return toAjax(deviceMaintainInfoService.insertDeviceMaintainInfo(deviceMaintainInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:info:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceMaintainInfo deviceMaintainInfo)
    {
        return toAjax(deviceMaintainInfoService.updateDeviceMaintainInfo(deviceMaintainInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:info:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceMaintainInfoService.deleteDeviceMaintainInfoByIds(ids));
    }
}
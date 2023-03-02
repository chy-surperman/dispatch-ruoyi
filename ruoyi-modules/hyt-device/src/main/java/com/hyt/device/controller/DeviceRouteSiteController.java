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
import com.hyt.device.domain.DeviceRouteSite;
import com.hyt.device.service.IDeviceRouteSiteService;
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
@Api("线路站点")
@RestController
@RequestMapping("/site")
public class DeviceRouteSiteController extends BaseController
{
    @Autowired
    private IDeviceRouteSiteService deviceRouteSiteService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("device:site:list")
    @GetMapping("/list")
    public TableDataInfo list(DeviceRouteSite deviceRouteSite)
    {
        startPage();
        List<DeviceRouteSite> list = deviceRouteSiteService.selectDeviceRouteSiteList(deviceRouteSite);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:site:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceRouteSite deviceRouteSite)
    {
        List<DeviceRouteSite> list = deviceRouteSiteService.selectDeviceRouteSiteList(deviceRouteSite);
        ExcelUtil<DeviceRouteSite> util = new ExcelUtil<DeviceRouteSite>(DeviceRouteSite.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:site:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceRouteSiteService.selectDeviceRouteSiteById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:site:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceRouteSite deviceRouteSite)
    {
        return toAjax(deviceRouteSiteService.insertDeviceRouteSite(deviceRouteSite));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:site:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceRouteSite deviceRouteSite)
    {
        return toAjax(deviceRouteSiteService.updateDeviceRouteSite(deviceRouteSite));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:site:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceRouteSiteService.deleteDeviceRouteSiteByIds(ids));
    }
}

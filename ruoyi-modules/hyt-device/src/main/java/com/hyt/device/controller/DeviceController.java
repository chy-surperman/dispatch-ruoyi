package com.hyt.device.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.hyt.device.domain.Device;
import com.hyt.device.service.IDeviceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author chy
 * @date 2023-02-24
 */
@Api("主机配置")
@RestController
@RequestMapping("/device")
public class DeviceController extends BaseController
{
    @Autowired
    private IDeviceService deviceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @ApiOperation("device列表分页")
    @RequiresPermissions("device:device:list")
    @GetMapping("/list")
    public TableDataInfo list(Device device)
    {
        startPage();
        List<Device> list = this.deviceService.selectDeviceList(device);
        return getDataTable(list);
    }


    /**
     * 查询【请填写功能名称】列表
     */
    @ApiOperation("通过公司名称，线路名 查找车辆信息 分页查询")
    @RequiresPermissions("device:device:list")
    @GetMapping("/listByParam")
    public TableDataInfo listByParam(String routeName,String company)
    {
        startPage();
        List<Device> list = deviceService.selectDeviceListAndParam(routeName,company);
        return getDataTable(list);
    }


    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:device:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出功能接口")
    public void export(HttpServletResponse response, Device device)
    {
        List<Device> list = deviceService.selectDeviceList(device);
        ExcelUtil<Device> util = new ExcelUtil<Device>(Device.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */

    @ApiOperation("通过ID查询主机参数列表")
    @RequiresPermissions("device:device:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceService.selectDeviceById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @ApiOperation("新增add")
    @RequiresPermissions("device:device:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Device device)
    {
        return toAjax(deviceService.insertDevice(device));
    }

    /**
     * 修改【请填写功能名称】
     */
    @ApiOperation("修改主机参数列表")
    @RequiresPermissions("device:device:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Device device)
    {
        return toAjax(deviceService.updateDevice(device));
    }

    /**
     * 删除【请填写功能名称】
     */
    @ApiOperation("删除主机通过ID参数列表")
    @RequiresPermissions("device:device:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceService.deleteDeviceByIds(ids));
    }
}

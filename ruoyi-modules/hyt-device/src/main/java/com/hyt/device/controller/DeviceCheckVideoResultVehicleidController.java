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
import com.hyt.device.domain.DeviceCheckVideoResultVehicleid;
import com.hyt.device.service.IDeviceCheckVideoResultVehicleidService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请LU功能名称】Controller
 * 
 * @author chy
 * @date 2023-03-01
 */
@Api("录像检测")
@RestController
@RequestMapping("/vehicleId")
public class DeviceCheckVideoResultVehicleidController extends BaseController
{
    @Autowired
    private IDeviceCheckVideoResultVehicleidService deviceCheckVideoResultVehicleidService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("device:vehicleId:list")
    @GetMapping("/list")
    public TableDataInfo list(DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        startPage();
        List<DeviceCheckVideoResultVehicleid> list = deviceCheckVideoResultVehicleidService.selectDeviceCheckVideoResultVehicleidList(deviceCheckVideoResultVehicleid);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:vehicleId:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        List<DeviceCheckVideoResultVehicleid> list = deviceCheckVideoResultVehicleidService.selectDeviceCheckVideoResultVehicleidList(deviceCheckVideoResultVehicleid);
        ExcelUtil<DeviceCheckVideoResultVehicleid> util = new ExcelUtil<DeviceCheckVideoResultVehicleid>(DeviceCheckVideoResultVehicleid.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:vehicleId:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceCheckVideoResultVehicleidService.selectDeviceCheckVideoResultVehicleidById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:vehicleId:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        return toAjax(deviceCheckVideoResultVehicleidService.insertDeviceCheckVideoResultVehicleid(deviceCheckVideoResultVehicleid));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:vehicleId:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceCheckVideoResultVehicleid deviceCheckVideoResultVehicleid)
    {
        return toAjax(deviceCheckVideoResultVehicleidService.updateDeviceCheckVideoResultVehicleid(deviceCheckVideoResultVehicleid));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:vehicleId:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceCheckVideoResultVehicleidService.deleteDeviceCheckVideoResultVehicleidByIds(ids));
    }
}

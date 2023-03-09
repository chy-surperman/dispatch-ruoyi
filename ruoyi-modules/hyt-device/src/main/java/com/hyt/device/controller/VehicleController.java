package com.hyt.device.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.hyt.device.domain.Vehicle;
import com.hyt.device.service.IVehicleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author chy
 * @date 2023-03-09
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController extends BaseController
{
    @Autowired
    private IVehicleService vehicleService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("device:vehicle:list")
    @GetMapping("/list")
    public TableDataInfo list(Vehicle vehicle)
    {
        startPage();
        List<Vehicle> list = vehicleService.selectVehicleList(vehicle);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:vehicle:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Vehicle vehicle)
    {
        List<Vehicle> list = vehicleService.selectVehicleList(vehicle);
        ExcelUtil<Vehicle> util = new ExcelUtil<Vehicle>(Vehicle.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:vehicle:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vehicleService.selectVehicleById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:vehicle:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Vehicle vehicle)
    {
        return toAjax(vehicleService.insertVehicle(vehicle));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:vehicle:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Vehicle vehicle)
    {
        return toAjax(vehicleService.updateVehicle(vehicle));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:vehicle:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vehicleService.deleteVehicleByIds(ids));
    }
}

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
import com.hyt.device.domain.DeviceCameralist;
import com.hyt.device.service.IDeviceCameralistService;
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
@Api("摄像头编号列表")
@RestController
@RequestMapping("/cameraList")
public class DeviceCameralistController extends BaseController
{

    private static final long serialVersionUID = 1L;

    @Autowired
    private IDeviceCameralistService deviceCameralistService;

    /**
     * 查询【摄像头列表】列表
     */
    @RequiresPermissions("device:cameraList:list")
    @GetMapping("/list")
    public TableDataInfo list(DeviceCameralist deviceCameralist)
    {
        startPage();
        List<DeviceCameralist> list = deviceCameralistService.selectDeviceCameralistList(deviceCameralist);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:cameraList:export")
    @Log(title = "【摄像头列表名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceCameralist deviceCameralist)
    {
        startPage();
        List<DeviceCameralist> list = deviceCameralistService.selectDeviceCameralistList(deviceCameralist);
        ExcelUtil<DeviceCameralist> util = new ExcelUtil<DeviceCameralist>(DeviceCameralist.class);
        util.exportExcel(response, list, "【摄像头列表】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:cameraList:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(deviceCameralistService.selectDeviceCameralistById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:cameraList:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceCameralist deviceCameralist)
    {
        return toAjax(deviceCameralistService.insertDeviceCameralist(deviceCameralist));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:cameraList:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceCameralist deviceCameralist)
    {
        return toAjax(deviceCameralistService.updateDeviceCameralist(deviceCameralist));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:cameraList:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(deviceCameralistService.deleteDeviceCameralistByIds(ids));
    }
}

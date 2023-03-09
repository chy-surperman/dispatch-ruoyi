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
import com.hyt.device.domain.DriverMsgStatus;
import com.hyt.device.service.IDriverMsgStatusService;
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
@RestController
@RequestMapping("/msgStatus")
public class DriverMsgStatusController extends BaseController
{
    @Autowired
    private IDriverMsgStatusService driverMsgStatusService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("device:status:list")
    @GetMapping("/list")
    public TableDataInfo list(DriverMsgStatus driverMsgStatus)
    {
        startPage();
        List<DriverMsgStatus> list = driverMsgStatusService.selectDriverMsgStatusList(driverMsgStatus);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:status:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DriverMsgStatus driverMsgStatus)
    {
        List<DriverMsgStatus> list = driverMsgStatusService.selectDriverMsgStatusList(driverMsgStatus);
        ExcelUtil<DriverMsgStatus> util = new ExcelUtil<DriverMsgStatus>(DriverMsgStatus.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:status:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(driverMsgStatusService.selectDriverMsgStatusById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:status:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DriverMsgStatus driverMsgStatus)
    {
        return toAjax(driverMsgStatusService.insertDriverMsgStatus(driverMsgStatus));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:status:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DriverMsgStatus driverMsgStatus)
    {
        return toAjax(driverMsgStatusService.updateDriverMsgStatus(driverMsgStatus));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:status:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(driverMsgStatusService.deleteDriverMsgStatusByIds(ids));
    }
}

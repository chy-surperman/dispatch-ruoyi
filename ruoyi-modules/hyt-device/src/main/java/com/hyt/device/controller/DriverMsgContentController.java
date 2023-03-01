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
import com.hyt.device.domain.DriverMsgContent;
import com.hyt.device.service.IDriverMsgContentService;
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
@Api("司机消息")
@RestController
@RequestMapping("/content")
public class DriverMsgContentController extends BaseController
{
    @Autowired
    private IDriverMsgContentService driverMsgContentService;

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("device:content:list")
    @GetMapping("/list")
    public TableDataInfo list(DriverMsgContent driverMsgContent)
    {
        startPage();
        List<DriverMsgContent> list = driverMsgContentService.selectDriverMsgContentList(driverMsgContent);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("device:content:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DriverMsgContent driverMsgContent)
    {
        List<DriverMsgContent> list = driverMsgContentService.selectDriverMsgContentList(driverMsgContent);
        ExcelUtil<DriverMsgContent> util = new ExcelUtil<DriverMsgContent>(DriverMsgContent.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @RequiresPermissions("device:content:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(driverMsgContentService.selectDriverMsgContentById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:content:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DriverMsgContent driverMsgContent)
    {
        return toAjax(driverMsgContentService.insertDriverMsgContent(driverMsgContent));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:content:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DriverMsgContent driverMsgContent)
    {
        return toAjax(driverMsgContentService.updateDriverMsgContent(driverMsgContent));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:content:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(driverMsgContentService.deleteDriverMsgContentByIds(ids));
    }
}

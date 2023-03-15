package com.hyt.device.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

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
import com.hyt.device.domain.FaultUrl;
import com.hyt.device.service.IFaultUrlService;
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
@Api("报修数据")
@RestController
@RequestMapping("/faultUrl")
public class FaultUrlController extends BaseController
{
    @Autowired
    private IFaultUrlService faultUrlService;

    /**
     * 查询【请填写功能名称】列表
     */
    @ApiOperation("查询【故障】列表")
    @RequiresPermissions("device:faultUrl:list")
    @GetMapping("/list")
    public TableDataInfo list(FaultUrl faultUrl)
    {
        startPage();
        List<FaultUrl> list = faultUrlService.selectFaultUrlList(faultUrl);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @ApiOperation("导出【故障】列表")
    @RequiresPermissions("device:faultUrl:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response,@RequestBody FaultUrl faultUrl)
    {
        List<FaultUrl> list = faultUrlService.selectFaultUrlList(faultUrl);
        ExcelUtil<FaultUrl> util = new ExcelUtil<FaultUrl>(FaultUrl.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @ApiOperation("获取【故障】详细信息")
    @RequiresPermissions("device:faultUrl:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(faultUrlService.selectFaultUrlById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("device:faultUrl:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增【故障】")
    public AjaxResult add(@RequestBody FaultUrl faultUrl)
    {
        return toAjax(faultUrlService.insertFaultUrl(faultUrl));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("device:faultUrl:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改【故障】")
    public AjaxResult edit(@RequestBody FaultUrl faultUrl)
    {
        if (StringUtils.isEmpty(faultUrl.getId().toString())) {
            return  toAjax(faultUrlService.insertFaultUrl(faultUrl));
        }
        return toAjax(faultUrlService.updateFaultUrl(faultUrl));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("device:faultUrl:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation("删除【故障】")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(faultUrlService.deleteFaultUrlByIds(ids));
    }
}

package com.hyt.device.controller;

import com.hyt.device.caches.CompanyCache;
import com.hyt.device.caches.RoutesNameCaches;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Description:
 * @Auther: Chy$
 */
@Api("基础数据类")
@RestController
@RequestMapping("/common")
public class BasicInfoController {

    @Autowired
    public CompanyCache companyCache;


    @Autowired
    public RoutesNameCaches routesNameCaches;
    
    
    

    @ApiOperation("获取公司列表")
    @RequestMapping("/companyName")
    public R getCompanyName(){
        Set<String> companyName = companyCache.getCompanyName();
        if (StringUtils.isEmpty(companyName)){
            return R.fail("查询缓存失败");
        }
        return R.ok(companyName,"查询数据成功");
    }



    @ApiOperation("获取线路名列表")
    @RequestMapping("/routeName")
    public R getRouteName(String company){
        Set<String> routeNames = routesNameCaches.getRouteNames(company);
        if (StringUtils.isEmpty(routeNames)){
            return R.fail("线路名获取失败");
        }
        return R.ok(routeNames,"查询数据成功");
    }
}

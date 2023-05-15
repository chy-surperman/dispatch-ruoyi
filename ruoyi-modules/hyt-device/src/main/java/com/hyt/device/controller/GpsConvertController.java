package com.hyt.device.controller;

import com.hyt.device.domain.GpsConvert;
import com.ruoyi.common.core.constant.CacheConstants;
import com.ruoyi.common.core.utils.GPSUtil;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <b><code>GpsConvertController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/5/15 11:28.
 *
 * @author xxx
 * @since dispatch-ruoyi Chy
 */
@Api("坐标系转换")
@RestController()
@RequestMapping("/gpsConvert")
public class GpsConvertController {


    @Autowired
    RedisService redisService;


    @PostMapping("/importData")
    @ResponseBody
    @ApiOperation("坐标系转换导入表格")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<GpsConvert> util = new ExcelUtil<GpsConvert>(GpsConvert.class);

        List<GpsConvert> gpsConvertList = util.importEasyExcel(file.getInputStream());
        String routeName=gpsConvertList.get(0).getRouteName();
        redisService.deleteCacheMapValue(CacheConstants.GPSConvertTool,routeName);

        for (GpsConvert gpsConvert:gpsConvertList) {
            double[] gps84_to_gcj02 = GPSUtil.gps84_To_Gcj02(Double.parseDouble(gpsConvert.getLatitude()), Double.parseDouble(gpsConvert.getLongitude()));
            gpsConvert.setLatitude(String.valueOf(gps84_to_gcj02[0]));
            gpsConvert.setLongitude(String.valueOf(gps84_to_gcj02[1]));
        }
        redisService.setCacheMapValue(CacheConstants.GPSConvertTool,routeName,gpsConvertList);
        return AjaxResult.success(gpsConvertList);
    }

    @Log(title = "坐标转换", businessType = BusinessType.EXPORT)
    @ApiOperation("坐标系转换导出表格")
    @PostMapping("/exportGpsConvertSite")
    public void export(HttpServletResponse response,GpsConvert gpsConvert) throws IOException
    {
        List<GpsConvert> gpsConvertList = redisService.getCacheMapValue(CacheConstants.GPSConvertTool, gpsConvert.getRouteName());
        ExcelUtil<GpsConvert> util = new ExcelUtil<GpsConvert>(GpsConvert.class);
        util.exportExcel(response, gpsConvertList, gpsConvert.getRouteName()+"火星坐标系");
    }
}

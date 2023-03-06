package com.hyt.device.caches;

import com.hyt.device.domain.DeviceRoutemsg;
import com.hyt.device.mapper.DeviceMapper;
import com.hyt.device.mapper.DeviceRoutemsgMapper;
import com.ruoyi.common.core.constant.CacheConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Auther: $
 */
@Component
public class RoutesNameCaches {

    @Autowired
    private DeviceRoutemsgMapper deviceRoutemsgMapper;


    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @PostConstruct
    public void start(){
        Set<String> companyNames = deviceRoutemsgMapper.selectCompanyName();

        for(String companyName:companyNames)
        {
            List<DeviceRoutemsg> deviceRoutemsgs = deviceRoutemsgMapper.selectRouteMsgNameByCompany(companyName);
            redisTemplate.opsForHash().put(CacheConstants.ALL_ROUTENAMES,companyName,deviceRoutemsgs);
        }
    }
    
    public List<DeviceRoutemsg> getRouteNames(String company){
        Object value = redisTemplate.opsForHash().get(CacheConstants.ALL_ROUTENAMES, company);
         return null == value? null:  (List<DeviceRoutemsg>)value;
    }

}

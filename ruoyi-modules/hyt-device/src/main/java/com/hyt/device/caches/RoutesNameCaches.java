package com.hyt.device.caches;

import com.hyt.device.mapper.DeviceMapper;
import com.ruoyi.common.core.constant.CacheConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @Description:
 * @Auther: $
 */
@Component
public class RoutesNameCaches {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private RedisTemplate routeNamesRedisTemplate;

    @PostConstruct
    public void start(){
        Set<String> companyNames = deviceMapper.selectCompanyName();

        for(String companyName:companyNames)
        {
            Set<String> routeNames = deviceMapper.selectRouteNameByCompany(companyName);
            routeNamesRedisTemplate.opsForHash().put(CacheConstants.ALL_ROUTENAMES,companyName,routeNames);
        }
    }
    
    public Set<String> getRouteNames(String company){
        Object value = routeNamesRedisTemplate.opsForHash().get(CacheConstants.ALL_ROUTENAMES, company);
         return null == value? null: (Set<String>) value;
    }
}

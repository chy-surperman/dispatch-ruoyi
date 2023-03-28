package com.hyt.device.caches;

import com.hyt.device.mapper.DeviceMapper;
import com.hyt.device.mapper.DeviceRoutemsgMapper;
import com.ruoyi.common.core.constant.CacheConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description:
 * @Auther: Chy$
 */
@Component
public class CompanyCache {


    @Autowired
    private DeviceRoutemsgMapper DeviceRoutemsgMapper;

    @Autowired
    private RedisTemplate<String, String> companyRedisTemplate;


    @PostConstruct
    public void start() {
        if(!companyRedisTemplate.hasKey(CacheConstants.COMPANY_NAME)){
            Set<String> companyName = DeviceRoutemsgMapper.selectCompanyName();
            Iterator<String> iterator = companyName.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                companyRedisTemplate.opsForSet().add(CacheConstants.COMPANY_NAME,next);
            }
        }
    }

    public Set<String> getCompanyName(){
        Set<String> members = companyRedisTemplate.opsForSet().members(CacheConstants.COMPANY_NAME);
        return null == members? null: (Set<String>) members;
    }
}

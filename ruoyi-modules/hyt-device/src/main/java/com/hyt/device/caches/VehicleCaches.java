package com.hyt.device.caches;

import com.hyt.device.domain.DeviceRoutemsg;
import com.hyt.device.domain.Vehicle;
import com.hyt.device.mapper.DeviceRoutemsgMapper;
import com.hyt.device.mapper.VehicleMapper;
import com.ruoyi.common.core.constant.CacheConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;


/**
 * @Description:
 * @Auther: Chy$
 */
@Component
public class VehicleCaches {

    @Resource
    private RedisTemplate<Object,Object> vehiclesRedisTemplate;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private DeviceRoutemsgMapper deviceRoutemsgMapper;

    @PostConstruct
    public void start(){
        List<DeviceRoutemsg> deviceRoutemsgs = deviceRoutemsgMapper.selectAllDeviceRoutemsg();

        for(DeviceRoutemsg deviceRoutemsg:deviceRoutemsgs)
        {
            List<Vehicle> vehicles = vehicleMapper.selectVehicleByRouteName(deviceRoutemsg.getRouteName());
            vehiclesRedisTemplate.opsForHash().put(CacheConstants.ALL_VEHICLES,deviceRoutemsg.getRouteName(),vehicles);
        }
    }

    public List<Vehicle> getVehicles(String routeName){
        Object value = vehiclesRedisTemplate.opsForHash().get(CacheConstants.ALL_VEHICLES, routeName);
        return null == value? null:  (List<Vehicle>)value;
    }
}

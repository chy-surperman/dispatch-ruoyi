package com.hyt.device.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyt.device.domain.Device;
import com.hyt.device.mapper.DeviceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IDeviceServiceTest {
    @Autowired
    private DeviceMapper deviceMapper;

    @Test
    void selectDeviceList() {

        PageHelper.startPage(0, 20);
        Device device = new Device();
        device.setCompany("通畅巴士");
        device.setRouteName("X102");
        List<Device> devices = deviceMapper.selectDeviceListAndPageNum("X102","通畅巴士");
        devices.forEach(s-> System.out.println(s.toString()));
        PageInfo<Device> devicePageInfo = new PageInfo<>(devices);
        System.out.println(devicePageInfo);

    }
}
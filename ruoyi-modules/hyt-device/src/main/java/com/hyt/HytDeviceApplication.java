package com.hyt;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
@MapperScan("com.hyt.device.mapper")
public class HytDeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HytDeviceApplication.class, args);
    }
    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverters() {
        FastJsonHttpMessageConverter additionalConverters = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero);
        additionalConverters.setFastJsonConfig(fastJsonConfig);

        return new HttpMessageConverters(additionalConverters);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
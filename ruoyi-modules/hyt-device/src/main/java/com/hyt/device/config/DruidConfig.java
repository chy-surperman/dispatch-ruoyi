package com.hyt.device.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Chy$
 */
@Component
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidSeverlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("resetEnable", "false");
        initParameters.put("allow", "127.0.0.1");
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "admin");
        servletRegistrationBean.setInitParameters(initParameters);
        return  servletRegistrationBean;
    }
}

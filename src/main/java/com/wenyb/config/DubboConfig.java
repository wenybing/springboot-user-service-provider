package com.wenyb.config;

/**
 * @Author wenyabing
 * @Date 2019/2/17 15:47
 */

import com.alibaba.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用注解API的方式配置dubbo
 */
@Configuration
public class DubboConfig {
    /**
     * <!--1、指定当前服务/应用名字（同样的服务名字相同、不要和别的服务同名）-->
     * <dobbo:application name="user-service-provider" />
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("springboot-user-service-provider");
        return applicationConfig;
    }


    /**
     * <!--2、指定注册中心的位置-->
     * <dubbo:registry address="zookeeper://127.0.0.1:2181" />
     * 或者
     * <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181" />
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

    /**
     * <!--3、指定通信规则 （通信协议？通信端口）-->
     * <dubbo:protocol name="dubbo" port="20880" />
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     * <!--4、暴露服务 ref:指向服务真正的实现-->
     * <dubbo:service interface="com.wenyb.service.UserService" ref="userServiceImpl" />
     */
    @Bean
    public ServiceConfig serviceConfig() {
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setInterface("com.wenyb.service.UserService");
        serviceConfig.setRef("userServiceImpl");
        return serviceConfig;
    }

    /**
     * <!--5、服务的实现-->
     * <bean id="userServiceImpl" class="com.wenyb.service.UserServiceImpl"></bean>
     * 不能使用如下方式，使用@Service
     */
//    @Bean
//    public UserServiceImpl userServiceImpl() {
//        UserServiceImpl userServiceImpl = new UserServiceImpl();
//        return userServiceImpl;
//    }

    /**
     * <!--配置监控中心-->
     * <!--<dubbo:monitor protocol="registry"></dubbo:monitor>-->
     * <dubbo:monitor address="127.0.0.1:7070"></dubbo:monitor>
     */
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
}

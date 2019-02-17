package com.wenyb.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wenyb.bean.UserAddress;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 1.将服务提供者注册到注册中心
 * 1)引入dubbo依赖（2.6.2）、操作zookeeper的客户端(curator)
 * 2)配置服务提供者
 * 2.让服务消费者去订阅服务提供者的服务地址
 *
 * @author Administrator
 */
@Service
@Component
public class UserServiceImpl implements UserService {


    @Override
    public List<UserAddress> getUserAddressList(String s) {
        UserAddress address1 = new UserAddress(1, "北京市朝阳区XXX软件园", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "西安市雁塔区XXX大厦", "1", "王老师", "010-56253825", "N");
        return Arrays.asList(address1, address2);
    }
}

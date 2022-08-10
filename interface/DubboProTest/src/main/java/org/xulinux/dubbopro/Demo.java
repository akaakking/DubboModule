package org.xulinux.dubbopro;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.xulinux.dubbopro.demo.DemoService;

import java.util.concurrent.CountDownLatch;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 下午6:25
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(new DemoServiceImpl());
        serviceConfig.setApplication(new ApplicationConfig("dubbo-demo-api-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setMetadataReportConfig(new MetadataReportConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.export();

        System.out.println("服务已开启");
        new CountDownLatch(1).await();
    }
}

package org.xulinux;



import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/31 下午8:08
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setInterface(DemoInterface.class);
        serviceConfig.setRef(new DemoImplment());
        serviceConfig.setApplication(new ApplicationConfig("dubbo-demo-api-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setMetadataReportConfig(new MetadataReportConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.export();
        System.out.println("服务已开启");
        new CountDownLatch(1).await();
    }
}

package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MetadataReportBuilder implements MetadataReportBuilderInterface {

    public MetadataReportBuilderInterface address(String address) {
        return instance.address(address);
    }

    public MetadataReportBuilderInterface username(String username) {
        return instance.username(username);
    }

    public MetadataReportBuilderInterface password(String password) {
        return instance.password(password);
    }

    public MetadataReportBuilderInterface timeout(Integer timeout) {
        return instance.timeout(timeout);
    }

    public MetadataReportBuilderInterface group(String group) {
        return instance.group(group);
    }

    public MetadataReportBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public MetadataReportBuilderInterface appendParameter(String key, String value) {
        return instance.appendParameter(key, value);
    }

    public MetadataReportBuilderInterface retryTimes(Integer retryTimes) {
        return instance.retryTimes(retryTimes);
    }

    public MetadataReportBuilderInterface retryPeriod(Integer retryPeriod) {
        return instance.retryPeriod(retryPeriod);
    }

    public MetadataReportBuilderInterface cycleReport(Boolean cycleReport) {
        return instance.cycleReport(cycleReport);
    }

    public MetadataReportBuilderInterface syncReport(Boolean syncReport) {
        return instance.syncReport(syncReport);
    }

    public MetadataReportBuilderInterface check(Boolean check) {
        return instance.check(check);
    }

    public MetadataReportConfigInterface build() {
        return instance.build();
    }

    protected MetadataReportBuilderInterface instance;

    public static MetadataReportBuilderInterface newBuilder() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }
}

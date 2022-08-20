package org.apache.dubbo.config.bootstrap.builders;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractBuilder;

public class MetadataReportBuilder extends AbstractBuilder<MetadataReportConfig, MetadataReportBuilder> implements MetadataReportBuilderInterface {

    public MetadataReportBuilderInterface address(StringInterface address) {
        return instance.address(address);
    }

    public MetadataReportBuilderInterface username(StringInterface username) {
        return instance.username(username);
    }

    public MetadataReportBuilderInterface password(StringInterface password) {
        return instance.password(password);
    }

    public MetadataReportBuilderInterface timeout(IntegerInterface timeout) {
        return instance.timeout(timeout);
    }

    public MetadataReportBuilderInterface group(StringInterface group) {
        return instance.group(group);
    }

    public MetadataReportBuilderInterface appendParameters(Map<String, String> appendParameters) {
        return instance.appendParameters(appendParameters);
    }

    public MetadataReportBuilderInterface appendParameter(StringInterface key, StringInterface value) {
        return instance.appendParameter(key, value);
    }

    public MetadataReportBuilderInterface retryTimes(IntegerInterface retryTimes) {
        return instance.retryTimes(retryTimes);
    }

    public MetadataReportBuilderInterface retryPeriod(IntegerInterface retryPeriod) {
        return instance.retryPeriod(retryPeriod);
    }

    public MetadataReportBuilderInterface cycleReport(BooleanInterface cycleReport) {
        return instance.cycleReport(cycleReport);
    }

    public MetadataReportBuilderInterface syncReport(BooleanInterface syncReport) {
        return instance.syncReport(syncReport);
    }

    public MetadataReportBuilderInterface check(BooleanInterface check) {
        return instance.check(check);
    }

    public MetadataReportConfigInterface build() {
        return instance.build();
    }

    public static MetadataReportBuilderInterface newBuilder() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(newBuilder);
        return method.invoke();
    }
}

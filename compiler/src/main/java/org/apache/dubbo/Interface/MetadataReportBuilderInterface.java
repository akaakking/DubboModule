package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface MetadataReportBuilderInterface{
    MetadataReportBuilderInterface newBuilder();
    MetadataReportBuilderInterface address(String address);
    MetadataReportBuilderInterface username(String username);
    MetadataReportBuilderInterface password(String password);
    MetadataReportBuilderInterface timeout(Integer timeout);
    MetadataReportBuilderInterface group(String group);
    MetadataReportBuilderInterface appendParameters(Map appendParameters);
    MetadataReportBuilderInterface appendParameter(String key, String value);
    MetadataReportBuilderInterface retryTimes(Integer retryTimes);
    MetadataReportBuilderInterface retryPeriod(Integer retryPeriod);
    MetadataReportBuilderInterface cycleReport(Boolean cycleReport);
    MetadataReportBuilderInterface syncReport(Boolean syncReport);
    MetadataReportBuilderInterface check(Boolean check);
    MetadataReportConfigInterface build();

}
package org.apache.dubbo.Interface;


public interface AggregationConfigInterface {
    Boolean getEnabled();
    void setEnabled(Boolean enabled);
    Integer getBucketNum();
    void setBucketNum(Integer bucketNum);
    Integer getTimeWindowSeconds();
    void setTimeWindowSeconds(Integer timeWindowSeconds);
}
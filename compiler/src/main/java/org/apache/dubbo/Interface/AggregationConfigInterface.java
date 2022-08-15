package org.apache.dubbo.Interface;


public interface AggregationConfigInterface extends Object{
    Boolean getEnabled();
    void setEnabled(Boolean enabled);
    Integer getBucketNum();
    void setBucketNum(Integer bucketNum);
    Integer getTimeWindowSeconds();
    void setTimeWindowSeconds(Integer timeWindowSeconds);
}
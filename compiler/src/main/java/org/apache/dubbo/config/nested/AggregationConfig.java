package org.apache.dubbo.config.nested;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AggregationConfig implements AggregationConfigInterface {

    public Boolean getEnabled() {
        return instance.getEnabled();
    }

    public void setEnabled(Boolean enabled) {
        instance.setEnabled(enabled);
    }

    public Integer getBucketNum() {
        return instance.getBucketNum();
    }

    public void setBucketNum(Integer bucketNum) {
        instance.setBucketNum(bucketNum);
    }

    public Integer getTimeWindowSeconds() {
        return instance.getTimeWindowSeconds();
    }

    public void setTimeWindowSeconds(Integer timeWindowSeconds) {
        instance.setTimeWindowSeconds(timeWindowSeconds);
    }

    protected AggregationConfigInterface instance;

    public AggregationConfigInterface getInternalInstance() {
        return instance;
    }
}

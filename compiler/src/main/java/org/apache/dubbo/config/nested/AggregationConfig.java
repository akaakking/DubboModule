package org.apache.dubbo.config.nested;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AggregationConfig implements AggregationConfigInterface {

    public BooleanInterface getEnabled() {
        return instance.getEnabled();
    }

    public void setEnabled(BooleanInterface enabled) {
        instance.setEnabled(enabled);
    }

    public IntegerInterface getBucketNum() {
        return instance.getBucketNum();
    }

    public void setBucketNum(IntegerInterface bucketNum) {
        instance.setBucketNum(bucketNum);
    }

    public IntegerInterface getTimeWindowSeconds() {
        return instance.getTimeWindowSeconds();
    }

    public void setTimeWindowSeconds(IntegerInterface timeWindowSeconds) {
        instance.setTimeWindowSeconds(timeWindowSeconds);
    }

    protected AggregationConfigInterface instance;
}

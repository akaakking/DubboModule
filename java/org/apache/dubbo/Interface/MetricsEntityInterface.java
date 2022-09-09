package org.apache.dubbo.Interface;

import java.lang.String;
import java.util.Map;
import org.apache.dubbo.common.metrics.model.MetricsCategory;
import java.lang.Object;

public interface MetricsEntityInterface {

    String getName();

    void setName(String name);

    Map<String, String> getTags();

    void setTags(Map<String, String> tags);

    MetricsCategory getCategory();

    void setCategory(MetricsCategory category);

    Object getValue();

    void setValue(Object value);

    boolean equals(Object o);

    int hashCode();
}

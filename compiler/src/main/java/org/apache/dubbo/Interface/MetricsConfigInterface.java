package org.apache.dubbo.Interface;

import org.apache.dubbo.common.URL;

public interface MetricsConfigInterface extends AbstractConfig{
    URL toUrl();
    String getProtocol();
    void setProtocol(String protocol);
    String getPort();
    void setPort(String port);
    PrometheusConfigInterface getPrometheus();
    void setPrometheus(PrometheusConfigInterface prometheus);
    AggregationConfigInterface getAggregation();
    void setAggregation(AggregationConfigInterface aggregation);
}
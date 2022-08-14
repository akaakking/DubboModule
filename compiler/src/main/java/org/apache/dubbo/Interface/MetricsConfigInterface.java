package org.apache.dubbo.Interface;

import java.lang;
import org.apache.dubbo.common;

public interface MetricsConfigInterface{
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
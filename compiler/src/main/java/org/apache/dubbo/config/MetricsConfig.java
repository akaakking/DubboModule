package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractConfig;

public class MetricsConfig extends AbstractConfig implements MetricsConfigInterface {

    public URLInterface toUrl() {
        return instance.toUrl();
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public void setProtocol(String protocol) {
        instance.setProtocol(protocol);
    }

    public String getPort() {
        return instance.getPort();
    }

    public void setPort(String port) {
        instance.setPort(port);
    }

    public PrometheusConfigInterface getPrometheus() {
        return instance.getPrometheus();
    }

    public void setPrometheus(PrometheusConfigInterface prometheus) {
        instance.setPrometheus(prometheus.getInternalInstance());
    }

    public AggregationConfigInterface getAggregation() {
        return instance.getAggregation();
    }

    public void setAggregation(AggregationConfigInterface aggregation) {
        instance.setAggregation(aggregation.getInternalInstance());
    }

    public MetricsConfigInterface getInternalInstance() {
        return instance;
    }

    public MetricsConfig() {
        instance = (MetricsConfigInterface) DubboClassLoader.getInstance(MetricsConfig.class.getName());
    }

    public MetricsConfig(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (MetricsConfigInterface) DubboClassLoader.getInstance(MetricsConfig.class.getName(), params, args);
    }
}

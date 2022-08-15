package org.apache.dubbo.Interface;


public interface PrometheusConfigInterface extends Object{
    ExporterInterface getExporter();
    void setExporter(ExporterInterface exporter);
    PushgatewayInterface getPushgateway();
    void setPushgateway(PushgatewayInterface pushgateway);
}
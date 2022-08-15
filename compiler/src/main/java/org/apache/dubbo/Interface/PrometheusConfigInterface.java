package org.apache.dubbo.Interface;


public interface PrometheusConfigInterface {
    ExporterInterface getExporter();
    void setExporter(ExporterInterface exporter);
    PushgatewayInterface getPushgateway();
    void setPushgateway(PushgatewayInterface pushgateway);
}
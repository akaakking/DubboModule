package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.PrometheusConfig$ExporterInterface;
import org.apache.dubbo.config.nested.PrometheusConfig.Exporter;
import org.apache.dubbo.Interface.PrometheusConfig$PushgatewayInterface;
import org.apache.dubbo.config.nested.PrometheusConfig.Pushgateway;

public interface PrometheusConfigInterface {

    ExporterInterface getExporter();

    void setExporter(ExporterInterface exporter);

    PushgatewayInterface getPushgateway();

    void setPushgateway(PushgatewayInterface pushgateway);
}

package org.apache.dubbo.config.nested;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class PrometheusConfig implements PrometheusConfigInterface {

    public ExporterInterface getExporter() {
        return instance.getExporter();
    }

    public void setExporter(ExporterInterface exporter) {
        instance.setExporter(exporter.getInternalInstance());
    }

    public PushgatewayInterface getPushgateway() {
        return instance.getPushgateway();
    }

    public void setPushgateway(PushgatewayInterface pushgateway) {
        instance.setPushgateway(pushgateway.getInternalInstance());
    }

    protected PrometheusConfigInterface instance;

    public PrometheusConfigInterface getInternalInstance() {
        return instance;
    }
}

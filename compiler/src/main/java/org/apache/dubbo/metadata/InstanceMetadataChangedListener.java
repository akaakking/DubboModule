package org.apache.dubbo.metadata;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class InstanceMetadataChangedListener implements InstanceMetadataChangedListenerInterface {

    public void onEvent(String metadata) {
        instance.onEvent(metadata);
    }

    public String echo(String msg) {
        return instance.echo(msg);
    }
}

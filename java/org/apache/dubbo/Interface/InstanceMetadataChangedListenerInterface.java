package org.apache.dubbo.Interface;

import java.lang.String;

public interface InstanceMetadataChangedListenerInterface {

    void onEvent(String metadata);

    String echo(String msg);
}

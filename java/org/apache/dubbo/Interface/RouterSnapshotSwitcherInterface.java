package org.apache.dubbo.Interface;

import java.lang.String;
import java.util.Set;

public interface RouterSnapshotSwitcherInterface {

    boolean isEnable();

    void addEnabledService(String service);

    boolean isEnable(String service);

    void removeEnabledService(String service);

    Set<String> getEnabledService();

    void setSnapshot(String snapshot);

    String[] cloneSnapshot();
}

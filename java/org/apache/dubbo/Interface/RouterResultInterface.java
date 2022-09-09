package org.apache.dubbo.Interface;

import java.util.List;

public interface RouterResultInterface<T> {

    boolean isNeedContinueRoute();

    List<T> getResult();

    String getMessage();
}

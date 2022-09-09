package org.apache.dubbo.Interface;

import T;

public interface HolderInterface<T> {

    void set(T value);

    T get();
}

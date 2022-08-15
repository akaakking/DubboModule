package org.apache.dubbo.Interface;

import org.apache.dubbo.common.URL;

public interface URLComparatorInterface extends Object, Comparator{
    int compare(URL o1, URL o2);
}
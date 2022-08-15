package org.apache.dubbo.Interface;

import org.apache.dubbo.common.status.Status;

public interface DataSourceStatusCheckerInterface extends Object, StatusChecker{
    Status check();
}
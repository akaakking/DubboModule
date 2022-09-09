package org.apache.dubbo.Interface;

import java.util.concurrent.ExecutorService;
import org.apache.dubbo.common.URL;
import java.util.concurrent.ScheduledExecutorService;

public interface ExecutorRepositoryInterface {

    ExecutorService createExecutorIfAbsent(URLInterface url);

    ExecutorService getExecutor(URLInterface url);

    void updateThreadpool(URLInterface url, ExecutorService executor);

    ScheduledExecutorService getServiceExportExecutor();

    void shutdownServiceExportExecutor();

    ExecutorService getServiceReferExecutor();

    void shutdownServiceReferExecutor();

    void destroyAll();

    ScheduledExecutorService nextScheduledExecutor();

    ExecutorService nextExecutorExecutor();

    ScheduledExecutorService getServiceDiscoveryAddressNotificationExecutor();

    ScheduledExecutorService getMetadataRetryExecutor();

    ScheduledExecutorService getRegistryNotificationExecutor();

    ExecutorService getSharedExecutor();

    ScheduledExecutorService getSharedScheduledExecutor();

    ExecutorService getPoolRouterExecutor();

    ScheduledExecutorService getConnectivityScheduledExecutor();

    ScheduledExecutorService getCacheRefreshingScheduledExecutor();

    ExecutorService getMappingRefreshingExecutor();
}

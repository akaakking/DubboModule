package org.apache.dubbo.common.threadpool.manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExecutorRepository implements ExecutorRepositoryInterface {

    public ExecutorService createExecutorIfAbsent(URLInterface url) {
        return instance.createExecutorIfAbsent(url);
    }

    public ExecutorService getExecutor(URLInterface url) {
        return instance.getExecutor(url);
    }

    public void updateThreadpool(URLInterface url, ExecutorService executor) {
        instance.updateThreadpool(url, executor);
    }

    public ScheduledExecutorService getServiceExportExecutor() {
        return instance.getServiceExportExecutor();
    }

    public void shutdownServiceExportExecutor() {
        instance.shutdownServiceExportExecutor();
    }

    public ExecutorService getServiceReferExecutor() {
        return instance.getServiceReferExecutor();
    }

    public void shutdownServiceReferExecutor() {
        instance.shutdownServiceReferExecutor();
    }

    public void destroyAll() {
        instance.destroyAll();
    }

    public ScheduledExecutorService nextScheduledExecutor() {
        return instance.nextScheduledExecutor();
    }

    public ExecutorService nextExecutorExecutor() {
        return instance.nextExecutorExecutor();
    }

    public ScheduledExecutorService getServiceDiscoveryAddressNotificationExecutor() {
        return instance.getServiceDiscoveryAddressNotificationExecutor();
    }

    public ScheduledExecutorService getMetadataRetryExecutor() {
        return instance.getMetadataRetryExecutor();
    }

    public ScheduledExecutorService getRegistryNotificationExecutor() {
        return instance.getRegistryNotificationExecutor();
    }

    public ExecutorService getSharedExecutor() {
        return instance.getSharedExecutor();
    }

    public ScheduledExecutorService getSharedScheduledExecutor() {
        return instance.getSharedScheduledExecutor();
    }

    public ExecutorService getPoolRouterExecutor() {
        return instance.getPoolRouterExecutor();
    }

    public ScheduledExecutorService getConnectivityScheduledExecutor() {
        return instance.getConnectivityScheduledExecutor();
    }

    public ScheduledExecutorService getCacheRefreshingScheduledExecutor() {
        return instance.getCacheRefreshingScheduledExecutor();
    }

    public ExecutorService getMappingRefreshingExecutor() {
        return instance.getMappingRefreshingExecutor();
    }
}

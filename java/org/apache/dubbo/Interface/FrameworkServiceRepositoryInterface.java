package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ProviderModel;
import org.apache.dubbo.Interface.ProviderModelInterface;
import java.lang.String;
import java.util.List;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import org.apache.dubbo.Interface.ConsumerModelInterface;

public interface FrameworkServiceRepositoryInterface {

    void registerProvider(ProviderModelInterface providerModel);

    void unregisterProvider(ProviderModelInterface providerModel);

    ProviderModelInterface lookupExportedServiceWithoutGroup(String key);

    List<ProviderModelInterface> lookupExportedServicesWithoutGroup(String key);

    void registerProviderUrl(URLInterface url);

    ProviderModelInterface lookupExportedService(String serviceKey);

    List<URLInterface> lookupRegisteredProviderUrlsWithoutGroup(String key);

    List<ProviderModelInterface> allProviderModels();

    List<ConsumerModelInterface> allConsumerModels();
}

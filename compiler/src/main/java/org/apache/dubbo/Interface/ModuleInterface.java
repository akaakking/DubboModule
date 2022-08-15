package org.apache.dubbo.Interface;

import java.util.function.Consumer;
import java.util.List;
import org.apache.dubbo.rpc.model.ModuleModel;

public interface ModuleInterface<S> {
    DubboBootstrapInterface endModule();
    ModuleModel getModuleModel();
    ModuleInterface<S> config(ModuleConfigInterface moduleConfig);
    ModuleInterface<S> service(Consumer consumerBuilder);
    ModuleInterface<S> service(String id, Consumer consumerBuilder);
    ModuleInterface<S> services(List serviceConfigs);
    ModuleInterface<S> service(ServiceConfigInterface<T> serviceConfig);
    ModuleInterface<S> reference(Consumer consumerBuilder);
    ModuleInterface<S> reference(String id, Consumer consumerBuilder);
    ModuleInterface<S> reference(ReferenceConfigInterface<T> referenceConfig);
    ModuleInterface<S> references(List referenceConfigs);
    ModuleInterface<S> provider(Consumer builderConsumer);
    ModuleInterface<S> provider(String id, Consumer builderConsumer);
    ModuleInterface<S> provider(ProviderConfigInterface providerConfig);
    ModuleInterface<S> providers(List providerConfigs);
    ModuleInterface<S> consumer(Consumer builderConsumer);
    ModuleInterface<S> consumer(String id, Consumer builderConsumer);
    ModuleInterface<S> consumer(ConsumerConfigInterface consumerConfig);
    ModuleInterface<S> consumers(List consumerConfigs);
}
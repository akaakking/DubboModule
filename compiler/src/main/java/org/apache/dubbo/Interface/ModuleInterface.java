package org.apache.dubbo.Interface;

import java.lang;
import java.util;
import org.apache.dubbo.rpc.model;
import java.util.function;

public interface ModuleInterface<T>{
    DubboBootstrapInterface endModule();
    ModuleModel getModuleModel();
    ModuleInterface config(ModuleConfigInterface moduleConfig);
    ModuleInterface service(Consumer consumerBuilder);
    ModuleInterface service(String id, Consumer consumerBuilder);
    ModuleInterface services(List serviceConfigs);
    ModuleInterface service(ServiceConfigInterface serviceConfig);
    ModuleInterface reference(Consumer consumerBuilder);
    ModuleInterface reference(String id, Consumer consumerBuilder);
    ModuleInterface reference(ReferenceConfigInterface referenceConfig);
    ModuleInterface references(List referenceConfigs);
    ModuleInterface provider(Consumer builderConsumer);
    ModuleInterface provider(String id, Consumer builderConsumer);
    ModuleInterface provider(ProviderConfigInterface providerConfig);
    ModuleInterface providers(List providerConfigs);
    ModuleInterface consumer(Consumer builderConsumer);
    ModuleInterface consumer(String id, Consumer builderConsumer);
    ModuleInterface consumer(ConsumerConfigInterface consumerConfig);
    ModuleInterface consumers(List consumerConfigs);

}
package org.apache.dubbo.Interface;

import org.apache.dubbo.common.extension.SPI;
import org.apache.dubbo.Interface.DubboBootstrapInterface;
import java.util.concurrent.Future;
import org.apache.dubbo.common.config.ReferenceCache;
import org.apache.dubbo.Interface.ApplicationConfigInterface;
import org.apache.dubbo.config.bootstrap.BootstrapTakeoverMode;
import org.apache.dubbo.Interface.ApplicationModelInterface;
import org.apache.dubbo.Interface.ConfigManagerInterface;
import java.util.function.Consumer;
import org.apache.dubbo.Interface.MetadataReportBuilderInterface;
import java.lang.String;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.Interface.MetadataReportConfigInterface;
import java.util.List;
import org.apache.dubbo.Interface.ApplicationBuilderInterface;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.Interface.RegistryBuilderInterface;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.Interface.RegistryConfigInterface;
import org.apache.dubbo.Interface.ProtocolBuilderInterface;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.Interface.ProtocolConfigInterface;
import org.apache.dubbo.Interface.ServiceBuilderInterface;
import org.apache.dubbo.Interface.ServiceConfigInterface;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.Interface.ModuleModelInterface;
import org.apache.dubbo.Interface.ReferenceBuilderInterface;
import org.apache.dubbo.Interface.ReferenceConfigInterface;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.Interface.ProviderBuilderInterface;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.Interface.ProviderConfigInterface;
import org.apache.dubbo.Interface.ConsumerBuilderInterface;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.Interface.ConsumerConfigInterface;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.Interface.ModuleConfigInterface;
import org.apache.dubbo.Interface.ConfigCenterBuilderInterface;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.Interface.ConfigCenterConfigInterface;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.Interface.MonitorConfigInterface;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.Interface.MetricsConfigInterface;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.Interface.SslConfigInterface;
import org.apache.dubbo.Interface.DubboBootstrap$ModuleInterface;

public interface DubboBootstrapInterface {

    void initialize();

    DubboBootstrapInterface start();

    DubboBootstrapInterface start(boolean wait);

    Future asyncStart();

    DubboBootstrapInterface stop();

    void destroy();

    boolean isInitialized();

    boolean isPending();

    boolean isRunning();

    boolean isStarting();

    boolean isStarted();

    boolean isStopping();

    boolean isStopped();

    DubboBootstrapInterface await();

    ReferenceCache getCache();

    ApplicationConfigInterface getApplication();

    void setTakeoverMode(BootstrapTakeoverMode takeoverMode);

    BootstrapTakeoverMode getTakeoverMode();

    ApplicationModelInterface getApplicationModel();

    ConfigManagerInterface getConfigManager();

    DubboBootstrapInterface metadataReport(Consumer<MetadataReportBuilderInterface> consumerBuilder);

    DubboBootstrapInterface metadataReport(String id, Consumer<MetadataReportBuilderInterface> consumerBuilder);

    DubboBootstrapInterface metadataReport(MetadataReportConfigInterface metadataReportConfig);

    DubboBootstrapInterface metadataReports(List<MetadataReportConfigInterface> metadataReportConfigs);

    DubboBootstrapInterface application(String name);

    DubboBootstrapInterface application(String name, Consumer<ApplicationBuilderInterface> consumerBuilder);

    DubboBootstrapInterface application(ApplicationConfigInterface applicationConfig);

    DubboBootstrapInterface registry(Consumer<RegistryBuilderInterface> consumerBuilder);

    DubboBootstrapInterface registry(String id, Consumer<RegistryBuilderInterface> consumerBuilder);

    DubboBootstrapInterface registry(RegistryConfigInterface registryConfig);

    DubboBootstrapInterface registries(List<RegistryConfigInterface> registryConfigs);

    DubboBootstrapInterface protocol(Consumer<ProtocolBuilderInterface> consumerBuilder);

    DubboBootstrapInterface protocol(String id, Consumer<ProtocolBuilderInterface> consumerBuilder);

    DubboBootstrapInterface protocol(ProtocolConfigInterface protocolConfig);

    DubboBootstrapInterface protocols(List<ProtocolConfigInterface> protocolConfigs);

    <S> DubboBootstrapInterface service(Consumer<ServiceBuilderInterface<S>> consumerBuilder);

    <S> DubboBootstrapInterface service(String id, Consumer<ServiceBuilderInterface<S>> consumerBuilder);

    DubboBootstrapInterface services(List<ServiceConfigInterface> serviceConfigs);

    DubboBootstrapInterface service(ServiceConfigInterface<?> serviceConfig);

    DubboBootstrapInterface service(ServiceConfigInterface<?> serviceConfig, ModuleModelInterface moduleModel);

    <S> DubboBootstrapInterface reference(Consumer<ReferenceBuilderInterface<S>> consumerBuilder);

    <S> DubboBootstrapInterface reference(String id, Consumer<ReferenceBuilderInterface<S>> consumerBuilder);

    DubboBootstrapInterface references(List<ReferenceConfigInterface> referenceConfigs);

    DubboBootstrapInterface reference(ReferenceConfigInterface<?> referenceConfig);

    DubboBootstrapInterface reference(ReferenceConfigInterface<?> referenceConfig, ModuleModelInterface moduleModel);

    DubboBootstrapInterface provider(Consumer<ProviderBuilderInterface> builderConsumer);

    DubboBootstrapInterface provider(String id, Consumer<ProviderBuilderInterface> builderConsumer);

    DubboBootstrapInterface provider(ProviderConfigInterface providerConfig);

    DubboBootstrapInterface providers(List<ProviderConfigInterface> providerConfigs);

    DubboBootstrapInterface provider(ProviderConfigInterface providerConfig, ModuleModelInterface moduleModel);

    DubboBootstrapInterface consumer(Consumer<ConsumerBuilderInterface> builderConsumer);

    DubboBootstrapInterface consumer(String id, Consumer<ConsumerBuilderInterface> builderConsumer);

    DubboBootstrapInterface consumer(ConsumerConfigInterface consumerConfig);

    DubboBootstrapInterface consumers(List<ConsumerConfigInterface> consumerConfigs);

    DubboBootstrapInterface consumer(ConsumerConfigInterface consumerConfig, ModuleModelInterface moduleModel);

    DubboBootstrapInterface module(ModuleConfigInterface moduleConfig);

    DubboBootstrapInterface module(ModuleConfigInterface moduleConfig, ModuleModelInterface moduleModel);

    DubboBootstrapInterface configCenter(Consumer<ConfigCenterBuilderInterface> consumerBuilder);

    DubboBootstrapInterface configCenter(String id, Consumer<ConfigCenterBuilderInterface> consumerBuilder);

    DubboBootstrapInterface configCenter(ConfigCenterConfigInterface configCenterConfig);

    DubboBootstrapInterface configCenters(List<ConfigCenterConfigInterface> configCenterConfigs);

    DubboBootstrapInterface monitor(MonitorConfigInterface monitor);

    DubboBootstrapInterface metrics(MetricsConfigInterface metrics);

    DubboBootstrapInterface ssl(SslConfigInterface sslConfig);

    ModuleInterface newModule();

    ModuleInterface newModule(ModuleConfigInterface moduleConfig);

    DubboBootstrapInterface endModule();
}

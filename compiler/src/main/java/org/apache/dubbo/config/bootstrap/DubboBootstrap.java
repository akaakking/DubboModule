package org.apache.dubbo.config.bootstrap;

import java.util.concurrent.Future;
import org.apache.dubbo.config.bootstrap.BootstrapTakeoverMode;
import java.util.function.Consumer;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBootstrap implements DubboBootstrapInterface {

    public void initialize() {
        instance.initialize();
    }

    public DubboBootstrapInterface start() {
        return instance.start();
    }

    public DubboBootstrapInterface start(boolean wait) {
        return instance.start(wait);
    }

    public Future asyncStart() {
        return instance.asyncStart();
    }

    public DubboBootstrapInterface stop() {
        return instance.stop();
    }

    public void destroy() {
        instance.destroy();
    }

    public boolean isInitialized() {
        return instance.isInitialized();
    }

    public boolean isPending() {
        return instance.isPending();
    }

    public boolean isRunning() {
        return instance.isRunning();
    }

    public boolean isStarting() {
        return instance.isStarting();
    }

    public boolean isStarted() {
        return instance.isStarted();
    }

    public boolean isStopping() {
        return instance.isStopping();
    }

    public boolean isStopped() {
        return instance.isStopped();
    }

    public DubboBootstrapInterface await() {
        return instance.await();
    }

    public ReferenceCacheInterface getCache() {
        return instance.getCache();
    }

    public ApplicationConfigInterface getApplication() {
        return instance.getApplication();
    }

    public void setTakeoverMode(BootstrapTakeoverModeInterface takeoverMode) {
        instance.setTakeoverMode(takeoverMode.getInternalInstance());
    }

    public BootstrapTakeoverModeInterface getTakeoverMode() {
        return instance.getTakeoverMode();
    }

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ConfigManagerInterface getConfigManager() {
        return instance.getConfigManager();
    }

    public DubboBootstrapInterface metadataReport(Consumer<MetadataReportBuilderInterface> consumerBuilder) {
        return instance.metadataReport(consumerBuilder);
    }

    public DubboBootstrapInterface metadataReport(String id, Consumer<MetadataReportBuilderInterface> consumerBuilder) {
        return instance.metadataReport(id, consumerBuilder);
    }

    public DubboBootstrapInterface metadataReport(MetadataReportConfigInterface metadataReportConfig) {
        return instance.metadataReport(metadataReportConfig.getInternalInstance());
    }

    public DubboBootstrapInterface metadataReports(List<MetadataReportConfigInterface> metadataReportConfigs) {
        return instance.metadataReports(metadataReportConfigs);
    }

    public DubboBootstrapInterface application(String name) {
        return instance.application(name);
    }

    public DubboBootstrapInterface application(String name, Consumer<ApplicationBuilderInterface> consumerBuilder) {
        return instance.application(name, consumerBuilder);
    }

    public DubboBootstrapInterface application(ApplicationConfigInterface applicationConfig) {
        return instance.application(applicationConfig.getInternalInstance());
    }

    public DubboBootstrapInterface registry(Consumer<RegistryBuilderInterface> consumerBuilder) {
        return instance.registry(consumerBuilder);
    }

    public DubboBootstrapInterface registry(String id, Consumer<RegistryBuilderInterface> consumerBuilder) {
        return instance.registry(id, consumerBuilder);
    }

    public DubboBootstrapInterface registry(RegistryConfigInterface registryConfig) {
        return instance.registry(registryConfig.getInternalInstance());
    }

    public DubboBootstrapInterface registries(List<RegistryConfigInterface> registryConfigs) {
        return instance.registries(registryConfigs);
    }

    public DubboBootstrapInterface protocol(Consumer<ProtocolBuilderInterface> consumerBuilder) {
        return instance.protocol(consumerBuilder);
    }

    public DubboBootstrapInterface protocol(String id, Consumer<ProtocolBuilderInterface> consumerBuilder) {
        return instance.protocol(id, consumerBuilder);
    }

    public DubboBootstrapInterface protocol(ProtocolConfigInterface protocolConfig) {
        return instance.protocol(protocolConfig.getInternalInstance());
    }

    public DubboBootstrapInterface protocols(List<ProtocolConfigInterface> protocolConfigs) {
        return instance.protocols(protocolConfigs);
    }

    public <S> DubboBootstrapInterface service(Consumer<ServiceBuilderInterface<S>> consumerBuilder) {
        return instance.service(consumerBuilder);
    }

    public <S> DubboBootstrapInterface service(String id, Consumer<ServiceBuilderInterface<S>> consumerBuilder) {
        return instance.service(id, consumerBuilder);
    }

    public DubboBootstrapInterface services(List<ServiceConfigInterface> serviceConfigs) {
        return instance.services(serviceConfigs);
    }

    public DubboBootstrapInterface service(ServiceConfigInterface<?> serviceConfig) {
        return instance.service(serviceConfig);
    }

    public DubboBootstrapInterface service(ServiceConfigInterface<?> serviceConfig, ModuleModelInterface moduleModel) {
        return instance.service(serviceConfig, moduleModel.getInternalInstance());
    }

    public <S> DubboBootstrapInterface reference(Consumer<ReferenceBuilderInterface<S>> consumerBuilder) {
        return instance.reference(consumerBuilder);
    }

    public <S> DubboBootstrapInterface reference(String id, Consumer<ReferenceBuilderInterface<S>> consumerBuilder) {
        return instance.reference(id, consumerBuilder);
    }

    public DubboBootstrapInterface references(List<ReferenceConfigInterface> referenceConfigs) {
        return instance.references(referenceConfigs);
    }

    public DubboBootstrapInterface reference(ReferenceConfigInterface<?> referenceConfig) {
        return instance.reference(referenceConfig);
    }

    public DubboBootstrapInterface reference(ReferenceConfigInterface<?> referenceConfig, ModuleModelInterface moduleModel) {
        return instance.reference(referenceConfig, moduleModel.getInternalInstance());
    }

    public DubboBootstrapInterface provider(Consumer<ProviderBuilderInterface> builderConsumer) {
        return instance.provider(builderConsumer);
    }

    public DubboBootstrapInterface provider(String id, Consumer<ProviderBuilderInterface> builderConsumer) {
        return instance.provider(id, builderConsumer);
    }

    public DubboBootstrapInterface provider(ProviderConfigInterface providerConfig) {
        return instance.provider(providerConfig.getInternalInstance());
    }

    public DubboBootstrapInterface providers(List<ProviderConfigInterface> providerConfigs) {
        return instance.providers(providerConfigs);
    }

    public DubboBootstrapInterface provider(ProviderConfigInterface providerConfig, ModuleModelInterface moduleModel) {
        return instance.provider(providerConfig.getInternalInstance(), moduleModel.getInternalInstance());
    }

    public DubboBootstrapInterface consumer(Consumer<ConsumerBuilderInterface> builderConsumer) {
        return instance.consumer(builderConsumer);
    }

    public DubboBootstrapInterface consumer(String id, Consumer<ConsumerBuilderInterface> builderConsumer) {
        return instance.consumer(id, builderConsumer);
    }

    public DubboBootstrapInterface consumer(ConsumerConfigInterface consumerConfig) {
        return instance.consumer(consumerConfig.getInternalInstance());
    }

    public DubboBootstrapInterface consumers(List<ConsumerConfigInterface> consumerConfigs) {
        return instance.consumers(consumerConfigs);
    }

    public DubboBootstrapInterface consumer(ConsumerConfigInterface consumerConfig, ModuleModelInterface moduleModel) {
        return instance.consumer(consumerConfig.getInternalInstance(), moduleModel.getInternalInstance());
    }

    public DubboBootstrapInterface module(ModuleConfigInterface moduleConfig) {
        return instance.module(moduleConfig.getInternalInstance());
    }

    public DubboBootstrapInterface module(ModuleConfigInterface moduleConfig, ModuleModelInterface moduleModel) {
        return instance.module(moduleConfig.getInternalInstance(), moduleModel.getInternalInstance());
    }

    public DubboBootstrapInterface configCenter(Consumer<ConfigCenterBuilderInterface> consumerBuilder) {
        return instance.configCenter(consumerBuilder);
    }

    public DubboBootstrapInterface configCenter(String id, Consumer<ConfigCenterBuilderInterface> consumerBuilder) {
        return instance.configCenter(id, consumerBuilder);
    }

    public DubboBootstrapInterface configCenter(ConfigCenterConfigInterface configCenterConfig) {
        return instance.configCenter(configCenterConfig.getInternalInstance());
    }

    public DubboBootstrapInterface configCenters(List<ConfigCenterConfigInterface> configCenterConfigs) {
        return instance.configCenters(configCenterConfigs);
    }

    public DubboBootstrapInterface monitor(MonitorConfigInterface monitor) {
        return instance.monitor(monitor.getInternalInstance());
    }

    public DubboBootstrapInterface metrics(MetricsConfigInterface metrics) {
        return instance.metrics(metrics.getInternalInstance());
    }

    public DubboBootstrapInterface ssl(SslConfigInterface sslConfig) {
        return instance.ssl(sslConfig.getInternalInstance());
    }

    public ModuleInterface newModule() {
        return instance.newModule();
    }

    public ModuleInterface newModule(ModuleConfigInterface moduleConfig) {
        return instance.newModule(moduleConfig.getInternalInstance());
    }

    public DubboBootstrapInterface endModule() {
        return instance.endModule();
    }

    protected DubboBootstrapInterface instance;

    public static DubboBootstrapInterface getInstance() {
        Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("getInstance");
        return method.invoke();
    }

    public static DubboBootstrapInterface getInstance(ApplicationModelInterface applicationModel) {
        Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("getInstance", ApplicationModelInterface.class);
        return method.invoke(applicationModel);
    }

    public static DubboBootstrapInterface newInstance() {
        Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("newInstance");
        return method.invoke();
    }

    public static DubboBootstrapInterface newInstance(FrameworkModelInterface frameworkModel) {
        Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("newInstance", FrameworkModelInterface.class);
        return method.invoke(frameworkModel);
    }

    public static void reset() {
        Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("reset");
        method.invoke();
    }

    public static void reset(boolean destroy) {
        Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("reset", boolean.class);
        method.invoke(destroy);
    }

    public DubboBootstrapInterface getInternalInstance() {
        return instance;
    }

    protected DubboBootstrap() {
        instance = (DubboBootstrapInterface) DubboClassLoader.getInstance(DubboBootstrap.class.getName());
    }
}

package org.apache.dubbo.config.bootstrap;

import java.util.concurrent.Future;
import org.apache.dubbo.config.bootstrap.BootstrapTakeoverMode;
import java.util.function.Consumer;
import java.lang.String;
import org.apache.dubbo.config.MetadataReportConfig;
import java.util.List;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;

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
        instance.setTakeoverMode(((BootstrapTakeoverMode) takeoverMode).getInternalInstance());
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
        return instance.metadataReport(((MetadataReportConfig) metadataReportConfig).getInternalInstance());
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
        return instance.application(((ApplicationConfig) applicationConfig).getInternalInstance());
    }

    public DubboBootstrapInterface registry(Consumer<RegistryBuilderInterface> consumerBuilder) {
        return instance.registry(consumerBuilder);
    }

    public DubboBootstrapInterface registry(String id, Consumer<RegistryBuilderInterface> consumerBuilder) {
        return instance.registry(id, consumerBuilder);
    }

    public DubboBootstrapInterface registry(RegistryConfigInterface registryConfig) {
        return instance.registry(((RegistryConfig) registryConfig).getInternalInstance());
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
        return instance.protocol(((ProtocolConfig) protocolConfig).getInternalInstance());
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
        return instance.service(serviceConfig, ((ModuleModel) moduleModel).getInternalInstance());
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
        return instance.reference(referenceConfig, ((ModuleModel) moduleModel).getInternalInstance());
    }

    public DubboBootstrapInterface provider(Consumer<ProviderBuilderInterface> builderConsumer) {
        return instance.provider(builderConsumer);
    }

    public DubboBootstrapInterface provider(String id, Consumer<ProviderBuilderInterface> builderConsumer) {
        return instance.provider(id, builderConsumer);
    }

    public DubboBootstrapInterface provider(ProviderConfigInterface providerConfig) {
        return instance.provider(((ProviderConfig) providerConfig).getInternalInstance());
    }

    public DubboBootstrapInterface providers(List<ProviderConfigInterface> providerConfigs) {
        return instance.providers(providerConfigs);
    }

    public DubboBootstrapInterface provider(ProviderConfigInterface providerConfig, ModuleModelInterface moduleModel) {
        return instance.provider(((ProviderConfig) providerConfig).getInternalInstance(), ((ModuleModel) moduleModel).getInternalInstance());
    }

    public DubboBootstrapInterface consumer(Consumer<ConsumerBuilderInterface> builderConsumer) {
        return instance.consumer(builderConsumer);
    }

    public DubboBootstrapInterface consumer(String id, Consumer<ConsumerBuilderInterface> builderConsumer) {
        return instance.consumer(id, builderConsumer);
    }

    public DubboBootstrapInterface consumer(ConsumerConfigInterface consumerConfig) {
        return instance.consumer(((ConsumerConfig) consumerConfig).getInternalInstance());
    }

    public DubboBootstrapInterface consumers(List<ConsumerConfigInterface> consumerConfigs) {
        return instance.consumers(consumerConfigs);
    }

    public DubboBootstrapInterface consumer(ConsumerConfigInterface consumerConfig, ModuleModelInterface moduleModel) {
        return instance.consumer(((ConsumerConfig) consumerConfig).getInternalInstance(), ((ModuleModel) moduleModel).getInternalInstance());
    }

    public DubboBootstrapInterface module(ModuleConfigInterface moduleConfig) {
        return instance.module(((ModuleConfig) moduleConfig).getInternalInstance());
    }

    public DubboBootstrapInterface module(ModuleConfigInterface moduleConfig, ModuleModelInterface moduleModel) {
        return instance.module(((ModuleConfig) moduleConfig).getInternalInstance(), ((ModuleModel) moduleModel).getInternalInstance());
    }

    public DubboBootstrapInterface configCenter(Consumer<ConfigCenterBuilderInterface> consumerBuilder) {
        return instance.configCenter(consumerBuilder);
    }

    public DubboBootstrapInterface configCenter(String id, Consumer<ConfigCenterBuilderInterface> consumerBuilder) {
        return instance.configCenter(id, consumerBuilder);
    }

    public DubboBootstrapInterface configCenter(ConfigCenterConfigInterface configCenterConfig) {
        return instance.configCenter(((ConfigCenterConfig) configCenterConfig).getInternalInstance());
    }

    public DubboBootstrapInterface configCenters(List<ConfigCenterConfigInterface> configCenterConfigs) {
        return instance.configCenters(configCenterConfigs);
    }

    public DubboBootstrapInterface monitor(MonitorConfigInterface monitor) {
        return instance.monitor(((MonitorConfig) monitor).getInternalInstance());
    }

    public DubboBootstrapInterface metrics(MetricsConfigInterface metrics) {
        return instance.metrics(((MetricsConfig) metrics).getInternalInstance());
    }

    public DubboBootstrapInterface ssl(SslConfigInterface sslConfig) {
        return instance.ssl(((SslConfig) sslConfig).getInternalInstance());
    }

    public ModuleInterface newModule() {
        return instance.newModule();
    }

    public ModuleInterface newModule(ModuleConfigInterface moduleConfig) {
        return instance.newModule(((ModuleConfig) moduleConfig).getInternalInstance());
    }

    public DubboBootstrapInterface endModule() {
        return instance.endModule();
    }

    protected DubboBootstrapInterface instance;

    public static DubboBootstrapInterface getInstance() {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("getInstance");
        return (DubboBootstrapInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static DubboBootstrapInterface getInstance(ApplicationModelInterface applicationModel) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("getInstance", ApplicationModelInterface.class);
        return (DubboBootstrapInterface)method.invoke(applicationModel);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static DubboBootstrapInterface newInstance() {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("newInstance");
        return (DubboBootstrapInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static DubboBootstrapInterface newInstance(FrameworkModelInterface frameworkModel) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("newInstance", FrameworkModelInterface.class);
        return (DubboBootstrapInterface)method.invoke(frameworkModel);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static void reset() {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("reset");
        method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static void reset(boolean destroy) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboBootstrap.class.getName());
        Method method = klass.getMethod("reset", boolean.class);
        method.invoke(destroy);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public DubboBootstrapInterface getInternalInstance() {
        return instance;
    }

    protected DubboBootstrap() {
        instance = (DubboBootstrapInterface) DubboClassLoader.getInstance(DubboBootstrap.class.getName());
    }
}

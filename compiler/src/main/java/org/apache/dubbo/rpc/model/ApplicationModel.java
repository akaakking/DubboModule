package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.util.Collection;

public class ApplicationModel extends ScopeModel implements ApplicationModelInterface {

    public FrameworkModelInterface getFrameworkModel() {
        return instance.getFrameworkModel();
    }

    public ModuleModelInterface newModule() {
        return instance.newModule();
    }

    public EnvironmentInterface getModelEnvironment() {
        return instance.getModelEnvironment();
    }

    public ConfigManagerInterface getApplicationConfigManager() {
        return instance.getApplicationConfigManager();
    }

    public ServiceRepositoryInterface getApplicationServiceRepository() {
        return instance.getApplicationServiceRepository();
    }

    public ExecutorRepositoryInterface getApplicationExecutorRepository() {
        return instance.getApplicationExecutorRepository();
    }

    public ApplicationConfigInterface getCurrentConfig() {
        return instance.getCurrentConfig();
    }

    public String getApplicationName() {
        return instance.getApplicationName();
    }

    public String tryGetApplicationName() {
        return instance.tryGetApplicationName();
    }

    public void removeModule(ModuleModelInterface moduleModel) {
        instance.removeModule(moduleModel.getInternalInstance(), moduleModel);
    }

    public List<ModuleModelInterface> getModuleModels() {
        return instance.getModuleModels();
    }

    public List<ModuleModelInterface> getPubModuleModels() {
        return instance.getPubModuleModels();
    }

    public ModuleModelInterface getDefaultModule() {
        return instance.getDefaultModule();
    }

    public ModuleModelInterface getInternalModule() {
        return instance.getInternalModule();
    }

    public void setEnvironment(EnvironmentInterface environment) {
        instance.setEnvironment(environment.getInternalInstance(), environment);
    }

    public void setConfigManager(ConfigManagerInterface configManager) {
        instance.setConfigManager(configManager.getInternalInstance(), configManager);
    }

    public void setServiceRepository(ServiceRepositoryInterface serviceRepository) {
        instance.setServiceRepository(serviceRepository.getInternalInstance(), serviceRepository);
    }

    public void addClassLoader(ClassLoader classLoader) {
        instance.addClassLoader(classLoader);
    }

    public void removeClassLoader(ClassLoader classLoader) {
        instance.removeClassLoader(classLoader);
    }

    public ApplicationDeployerInterface getDeployer() {
        return instance.getDeployer();
    }

    public void setDeployer(ApplicationDeployerInterface deployer) {
        instance.setDeployer(deployer.getInternalInstance(), deployer);
    }

    public static ApplicationModelInterface ofNullable(ApplicationModelInterface applicationModel) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(ofNullable, ApplicationModelInterface.class);
        return method.invoke(applicationModel);
    }

    public static ApplicationModelInterface defaultModel() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(defaultModel);
        return method.invoke();
    }

    public static Collection<ConsumerModelInterface> allConsumerModels() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(allConsumerModels);
        return method.invoke();
    }

    public static Collection<ProviderModelInterface> allProviderModels() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(allProviderModels);
        return method.invoke();
    }

    public static ProviderModelInterface getProviderModel(String serviceKey) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getProviderModel, String.class);
        return method.invoke(serviceKey);
    }

    public static ConsumerModelInterface getConsumerModel(String serviceKey) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getConsumerModel, String.class);
        return method.invoke(serviceKey);
    }

    public static EnvironmentInterface getEnvironment() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getEnvironment);
        return method.invoke();
    }

    public static ConfigManagerInterface getConfigManager() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getConfigManager);
        return method.invoke();
    }

    public static ServiceRepositoryInterface getServiceRepository() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getServiceRepository);
        return method.invoke();
    }

    public static ExecutorRepositoryInterface getExecutorRepository() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getExecutorRepository);
        return method.invoke();
    }

    public static ApplicationConfigInterface getApplicationConfig() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getApplicationConfig);
        return method.invoke();
    }

    public static String getName() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getName);
        return method.invoke();
    }

    public static String getApplication() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getApplication);
        return method.invoke();
    }

    public static void reset() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(reset);
        method.invoke();
    }

    public ApplicationModelInterface getInternalInstance() {
        return instance;
    }

    public ApplicationModelInterface getInternalInstance() {
        return instance;
    }

    public ApplicationModel(FrameworkModelInterface frameworkModel) {
        Class[] params = new Class[]{FrameworkModelInterface.class};
        Object[] args = new Object[]{frameworkModel};
        instance = (ApplicationModelInterface) DubboClassLoader.getInstance(ApplicationModel.class.getName(), params, args);
    }

    public ApplicationModel(FrameworkModelInterface frameworkModel, boolean isInternal) {
        Class[] params = new Class[]{FrameworkModelInterface.class, boolean.class};
        Object[] args = new Object[]{frameworkModel, isInternal};
        instance = (ApplicationModelInterface) DubboClassLoader.getInstance(ApplicationModel.class.getName(), params, args);
    }
}

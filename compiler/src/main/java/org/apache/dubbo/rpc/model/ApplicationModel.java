package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ApplicationModel implements ApplicationModelInterface {

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
        instance.removeModule(moduleModel);
    }

    public List<ModuleModel> getModuleModels() {
        return instance.getModuleModels();
    }

    public List<ModuleModel> getPubModuleModels() {
        return instance.getPubModuleModels();
    }

    public ModuleModelInterface getDefaultModule() {
        return instance.getDefaultModule();
    }

    public ModuleModelInterface getInternalModule() {
        return instance.getInternalModule();
    }

    public void setEnvironment(EnvironmentInterface environment) {
        instance.setEnvironment(environment);
    }

    public void setConfigManager(ConfigManagerInterface configManager) {
        instance.setConfigManager(configManager);
    }

    public void setServiceRepository(ServiceRepositoryInterface serviceRepository) {
        instance.setServiceRepository(serviceRepository);
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
        instance.setDeployer(deployer);
    }

    protected ApplicationModelInterface instance;

    public static ApplicationModelInterface ofNullable(ApplicationModelInterface applicationModel) {
        Method method = instance.getClass().getMethod(ApplicationModelInterface.class);
        return method.invoke(applicationModel);
    }

    public static ApplicationModelInterface defaultModel() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static Collection<ConsumerModel> allConsumerModels() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static Collection<ProviderModel> allProviderModels() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static ProviderModelInterface getProviderModel(String serviceKey) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(serviceKey);
    }

    public static ConsumerModelInterface getConsumerModel(String serviceKey) {
        Method method = instance.getClass().getMethod(String.class);
        return method.invoke(serviceKey);
    }

    public static EnvironmentInterface getEnvironment() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static ConfigManagerInterface getConfigManager() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static ServiceRepositoryInterface getServiceRepository() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static ExecutorRepositoryInterface getExecutorRepository() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static ApplicationConfigInterface getApplicationConfig() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static String getName() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static String getApplication() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static void reset() {
        Method method = instance.getClass().getMethod();
        method.invoke();
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

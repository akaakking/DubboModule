package org.apache.dubbo.rpc.model;

import org.apache.dubbo.rpc.model.ModuleModel;
import java.util.List;
import org.apache.dubbo.common.config.Environment;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.rpc.model.ServiceRepository;
import java.lang.ClassLoader;
import org.apache.dubbo.common.deploy.ApplicationDeployer;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.lang.reflect.Method;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.Collection;
import java.lang.String;

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
        instance.removeModule(((ModuleModel) moduleModel).getInternalInstance());
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
        instance.setEnvironment(((Environment) environment).getInternalInstance());
    }

    public void setConfigManager(ConfigManagerInterface configManager) {
        instance.setConfigManager(((ConfigManager) configManager).getInternalInstance());
    }

    public void setServiceRepository(ServiceRepositoryInterface serviceRepository) {
        instance.setServiceRepository(((ServiceRepository) serviceRepository).getInternalInstance());
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
        instance.setDeployer(((ApplicationDeployer) deployer).getInternalInstance());
    }

    protected ApplicationModelInterface instance;

    public static ApplicationModelInterface ofNullable(ApplicationModelInterface applicationModel) {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("ofNullable", ApplicationModelInterface.class);
        return (ApplicationModelInterface)method.invoke(applicationModel);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ApplicationModelInterface defaultModel() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("defaultModel");
        return (ApplicationModelInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Collection<ConsumerModelInterface> allConsumerModels() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("allConsumerModels");
        return (Collection<ConsumerModelInterface>)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static Collection<ProviderModelInterface> allProviderModels() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("allProviderModels");
        return (Collection<ProviderModelInterface>)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ProviderModelInterface getProviderModel(String serviceKey) {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getProviderModel", String.class);
        return (ProviderModelInterface)method.invoke(serviceKey);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ConsumerModelInterface getConsumerModel(String serviceKey) {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getConsumerModel", String.class);
        return (ConsumerModelInterface)method.invoke(serviceKey);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static EnvironmentInterface getEnvironment() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getEnvironment");
        return (EnvironmentInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ConfigManagerInterface getConfigManager() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getConfigManager");
        return (ConfigManagerInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ServiceRepositoryInterface getServiceRepository() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getServiceRepository");
        return (ServiceRepositoryInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ExecutorRepositoryInterface getExecutorRepository() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getExecutorRepository");
        return (ExecutorRepositoryInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static ApplicationConfigInterface getApplicationConfig() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getApplicationConfig");
        return (ApplicationConfigInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String getName() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getName");
        return (String)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String getApplication() {
        try { 
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
        Method method = klass.getMethod("getApplication");
        return (String)method.invoke();
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
          Class klass = DubboClassLoader.getKlass(ApplicationModel.class.getName());
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

    public ApplicationModelInterface getInternalInstance() {
        return instance;
    }

    public ApplicationModel(FrameworkModelInterface frameworkModel) {
        Class[] params = new Class[]{FrameworkModelInterface.class};
        Object[] args = new Object[]{frameworkModel};
        instance = (ApplicationModelInterface) DubboClassLoader.getInstance(ApplicationModel.class.getName(), params, args);
        super.instance = this.instance;
    }

    public ApplicationModel(FrameworkModelInterface frameworkModel, boolean isInternal) {
        Class[] params = new Class[]{FrameworkModelInterface.class, boolean.class};
        Object[] args = new Object[]{frameworkModel, isInternal};
        instance = (ApplicationModelInterface) DubboClassLoader.getInstance(ApplicationModel.class.getName(), params, args);
        super.instance = this.instance;
    }

    protected ApplicationModel() {
        instance = (ApplicationModelInterface) DubboClassLoader.getInstance(ApplicationModel.class.getName());
        super.instance = this.instance;
    }
}

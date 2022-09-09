package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.Interface.FrameworkModelInterface;
import org.apache.dubbo.Interface.ModuleModelInterface;
import org.apache.dubbo.Interface.EnvironmentInterface;
import org.apache.dubbo.Interface.ConfigManagerInterface;
import org.apache.dubbo.Interface.ServiceRepositoryInterface;
import org.apache.dubbo.common.threadpool.manager.ExecutorRepository;
import org.apache.dubbo.Interface.ApplicationConfigInterface;
import org.apache.dubbo.rpc.model.ModuleModel;
import java.util.List;
import org.apache.dubbo.common.config.Environment;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.rpc.model.ServiceRepository;
import java.lang.ClassLoader;
import org.apache.dubbo.common.deploy.ApplicationDeployer;

public interface ApplicationModelInterface extends ScopeModelInterface {

    FrameworkModelInterface getFrameworkModel();

    ModuleModelInterface newModule();

    EnvironmentInterface getModelEnvironment();

    ConfigManagerInterface getApplicationConfigManager();

    ServiceRepositoryInterface getApplicationServiceRepository();

    ExecutorRepository getApplicationExecutorRepository();

    ApplicationConfigInterface getCurrentConfig();

    String getApplicationName();

    String tryGetApplicationName();

    void removeModule(ModuleModelInterface moduleModel);

    List<ModuleModelInterface> getModuleModels();

    List<ModuleModelInterface> getPubModuleModels();

    ModuleModelInterface getDefaultModule();

    ModuleModelInterface getInternalModule();

    void setEnvironment(EnvironmentInterface environment);

    void setConfigManager(ConfigManagerInterface configManager);

    void setServiceRepository(ServiceRepositoryInterface serviceRepository);

    void addClassLoader(ClassLoader classLoader);

    void removeClassLoader(ClassLoader classLoader);

    ApplicationDeployer getDeployer();

    void setDeployer(ApplicationDeployer deployer);
}

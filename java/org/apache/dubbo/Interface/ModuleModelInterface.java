package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.Interface.ApplicationModelInterface;
import org.apache.dubbo.Interface.ModuleServiceRepositoryInterface;
import java.lang.ClassLoader;
import org.apache.dubbo.Interface.ModuleEnvironmentInterface;
import org.apache.dubbo.Interface.ModuleConfigManagerInterface;
import org.apache.dubbo.common.deploy.ModuleDeployer;
import org.apache.dubbo.common.config.ModuleEnvironment;
import org.apache.dubbo.Interface.ConsumerModelInterface;
import java.lang.Class;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;

public interface ModuleModelInterface extends ScopeModelInterface {

    ApplicationModelInterface getApplicationModel();

    ModuleServiceRepositoryInterface getServiceRepository();

    void addClassLoader(ClassLoader classLoader);

    ModuleEnvironmentInterface getModelEnvironment();

    ModuleConfigManagerInterface getConfigManager();

    ModuleDeployer getDeployer();

    void setDeployer(ModuleDeployer deployer);

    void setModuleEnvironment(ModuleEnvironmentInterface moduleEnvironment);

    ConsumerModelInterface registerInternalConsumer(Class<?> internalService, URLInterface url);
}

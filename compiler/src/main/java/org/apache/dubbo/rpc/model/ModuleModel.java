package org.apache.dubbo.rpc.model;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ScopeModel;

public class ModuleModel extends ScopeModel implements ModuleModelInterface {

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ModuleServiceRepositoryInterface getServiceRepository() {
        return instance.getServiceRepository();
    }

    public void addClassLoader(ClassLoader classLoader) {
        instance.addClassLoader(classLoader);
    }

    public ModuleEnvironmentInterface getModelEnvironment() {
        return instance.getModelEnvironment();
    }

    public ModuleConfigManagerInterface getConfigManager() {
        return instance.getConfigManager();
    }

    public ModuleDeployerInterface getDeployer() {
        return instance.getDeployer();
    }

    public void setDeployer(ModuleDeployerInterface deployer) {
        instance.setDeployer(deployer.getInternalInstance());
    }

    public void setModuleEnvironment(ModuleEnvironmentInterface moduleEnvironment) {
        instance.setModuleEnvironment(moduleEnvironment.getInternalInstance());
    }

    public ConsumerModelInterface registerInternalConsumer(Class<?> internalService, URLInterface url) {
        return instance.registerInternalConsumer(internalService, url.getInternalInstance());
    }

    public ModuleModelInterface getInternalInstance() {
        return instance;
    }

    public ModuleModel(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ModuleModelInterface) DubboClassLoader.getInstance(ModuleModel.class.getName(), params, args);
    }

    public ModuleModel(ApplicationModelInterface applicationModel, boolean isInternal) {
        Class[] params = new Class[]{ApplicationModelInterface.class, boolean.class};
        Object[] args = new Object[]{applicationModel, isInternal};
        instance = (ModuleModelInterface) DubboClassLoader.getInstance(ModuleModel.class.getName(), params, args);
    }
}

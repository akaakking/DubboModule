package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ScopeModel;

public class FrameworkModel extends ScopeModel implements FrameworkModelInterface {

    public ApplicationModelInterface newApplication() {
        return instance.newApplication();
    }

    public ApplicationModelInterface defaultApplication() {
        return instance.defaultApplication();
    }

    public List<ApplicationModelInterface> getApplicationModels() {
        return instance.getApplicationModels();
    }

    public List<ApplicationModelInterface> getAllApplicationModels() {
        return instance.getAllApplicationModels();
    }

    public ApplicationModelInterface getInternalApplicationModel() {
        return instance.getInternalApplicationModel();
    }

    public FrameworkServiceRepositoryInterface getServiceRepository() {
        return instance.getServiceRepository();
    }

    public EnvironmentInterface getModelEnvironment() {
        return instance.getModelEnvironment();
    }

    public static FrameworkModelInterface defaultModel() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(defaultModel);
        return method.invoke();
    }

    public static List<FrameworkModelInterface> getAllInstances() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(getAllInstances);
        return method.invoke();
    }

    public static void destroyAll() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(destroyAll);
        method.invoke();
    }

    public FrameworkModelInterface getInternalInstance() {
        return instance;
    }

    public FrameworkModelInterface getInternalInstance() {
        return instance;
    }

    public FrameworkModel() {
        instance = (FrameworkModelInterface) DubboClassLoader.getInstance(FrameworkModel.class.getName());
    }
}

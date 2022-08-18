package org.apache.dubbo.rpc.model;

import java.util.Map;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class FrameworkModel implements FrameworkModelInterface {

    public ApplicationModelInterface newApplication() {
        return instance.newApplication();
    }

    public ApplicationModelInterface defaultApplication() {
        return instance.defaultApplication();
    }

    public List<ApplicationModel> getApplicationModels() {
        return instance.getApplicationModels();
    }

    public List<ApplicationModel> getAllApplicationModels() {
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

    protected FrameworkModelInterface instance;

    public static FrameworkModelInterface defaultModel() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static List<FrameworkModel> getAllInstances() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }

    public static void destroyAll() {
        Method method = instance.getClass().getMethod();
        method.invoke();
    }

    public FrameworkModel() {
        instance = (FrameworkModelInterface) DubboClassLoader.getInstance(FrameworkModel.class.getName());
    }
}

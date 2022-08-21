package org.apache.dubbo.rpc.model;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.rpc.model.ScopeModel;
import java.lang.reflect.Method;

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

    protected FrameworkModelInterface instance;

    public static FrameworkModelInterface defaultModel() {
        try { 
          Class klass = DubboClassLoader.getKlass(FrameworkModel.class.getName());
        Method method = klass.getMethod("defaultModel");
        return (FrameworkModelInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static List<FrameworkModelInterface> getAllInstances() {
        try { 
          Class klass = DubboClassLoader.getKlass(FrameworkModel.class.getName());
        Method method = klass.getMethod("getAllInstances");
        return (List<FrameworkModelInterface>)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static void destroyAll() {
        try { 
          Class klass = DubboClassLoader.getKlass(FrameworkModel.class.getName());
        Method method = klass.getMethod("destroyAll");
        method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public FrameworkModelInterface getInternalInstance() {
        return instance;
    }

    public FrameworkModel() {
        instance = (FrameworkModelInterface) DubboClassLoader.getInstance(FrameworkModel.class.getName());
        super.instance = this.instance;
    }
}

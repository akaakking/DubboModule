package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.Interface.ApplicationModelInterface;
import java.util.List;
import org.apache.dubbo.Interface.FrameworkServiceRepositoryInterface;
import org.apache.dubbo.Interface.EnvironmentInterface;

public interface FrameworkModelInterface extends ScopeModelInterface {

    ApplicationModelInterface newApplication();

    ApplicationModelInterface defaultApplication();

    List<ApplicationModelInterface> getApplicationModels();

    List<ApplicationModelInterface> getAllApplicationModels();

    ApplicationModelInterface getInternalApplicationModel();

    FrameworkServiceRepositoryInterface getServiceRepository();

    EnvironmentInterface getModelEnvironment();
}

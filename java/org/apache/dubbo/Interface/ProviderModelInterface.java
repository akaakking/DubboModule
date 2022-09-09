package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ServiceModelInterface;
import java.util.List;
import org.apache.dubbo.Interface.ProviderModel$RegisterStatedURLInterface;
import org.apache.dubbo.rpc.model.ProviderModel.RegisterStatedURL;
import org.apache.dubbo.Interface.ProviderMethodModelInterface;
import java.lang.String;
import org.apache.dubbo.Interface.URLInterface;
import java.lang.Object;

public interface ProviderModelInterface extends ServiceModelInterface {

    Object getServiceInstance();

    List<RegisterStatedURLInterface> getStatedUrl();

    void addStatedUrl(RegisterStatedURLInterface url);

    List<ProviderMethodModelInterface> getAllMethodModels();

    ProviderMethodModelInterface getMethodModel(String methodName, String[] argTypes);

    List<ProviderMethodModelInterface> getMethodModelList(String methodName);

    List<URLInterface> getServiceUrls();

    void setServiceUrls(List<URLInterface> urls);

    boolean equals(Object o);

    int hashCode();
}

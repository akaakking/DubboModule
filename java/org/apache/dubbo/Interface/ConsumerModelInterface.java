package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ServiceModelInterface;
import org.apache.dubbo.Interface.AsyncMethodInfoInterface;
import java.lang.String;
import java.util.Set;
import org.apache.dubbo.Interface.ConsumerMethodModelInterface;
import java.lang.reflect.Method;
import java.util.List;
import java.lang.Object;

public interface ConsumerModelInterface extends ServiceModelInterface {

    AsyncMethodInfoInterface getMethodConfig(String methodName);

    Set<String> getApps();

    AsyncMethodInfoInterface getAsyncInfo(String methodName);

    void initMethodModels();

    ConsumerMethodModelInterface getMethodModel(Method method);

    ConsumerMethodModelInterface getMethodModel(String method);

    ConsumerMethodModelInterface getMethodModel(String method, String[] argsType);

    List<ConsumerMethodModelInterface> getAllMethodModels();

    boolean equals(Object o);

    int hashCode();
}

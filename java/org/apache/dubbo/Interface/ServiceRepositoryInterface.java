package org.apache.dubbo.Interface;

import java.util.Collection;
import org.apache.dubbo.Interface.ConsumerModelInterface;
import org.apache.dubbo.Interface.ProviderModelInterface;

public interface ServiceRepositoryInterface {

    void destroy();

    Collection<ConsumerModelInterface> allConsumerModels();

    Collection<ProviderModelInterface> allProviderModels();
}

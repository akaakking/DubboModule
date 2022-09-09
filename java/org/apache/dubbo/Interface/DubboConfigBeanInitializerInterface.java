/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.Interface;

import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.MetricsConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.config.context.AbstractConfigManager;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.config.spring.ConfigCenterBean;
import org.apache.dubbo.config.spring.reference.ReferenceBeanManager;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Dubbo config bean initializer.
 *
 * NOTE: Dubbo config beans MUST be initialized after registering all BeanPostProcessors,
 * that is after the AbstractApplicationContext#registerBeanPostProcessors() method.
 */
public class DubboConfigBeanInitializer implements BeanFactoryAware, InitializingBean {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException;

    @Override
    public void afterPropertiesSet() throws Exception;

    private void init();

    /**
     * Initializes there Dubbo's Config Beans before @Reference bean autowiring
     */
    private void prepareDubboConfigBeans();

    private void loadConfigBeansOfType(Class<? extends AbstractConfig> configClass, AbstractConfigManager configManager);
}

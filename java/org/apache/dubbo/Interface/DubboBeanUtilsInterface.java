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

import org.apache.dubbo.config.spring.beans.factory.annotation.DubboConfigAliasPostProcessor;
import org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor;
import org.apache.dubbo.config.spring.beans.factory.annotation.ServicePackagesHolder;
import org.apache.dubbo.config.spring.beans.factory.config.DubboConfigDefaultPropertyValueBeanPostProcessor;
import org.apache.dubbo.config.spring.context.DubboConfigApplicationListener;
import org.apache.dubbo.config.spring.context.DubboConfigBeanInitializer;
import org.apache.dubbo.config.spring.context.DubboDeployApplicationListener;
import org.apache.dubbo.config.spring.context.DubboInfraBeanRegisterPostProcessor;
import org.apache.dubbo.config.spring.context.DubboSpringInitContext;
import org.apache.dubbo.config.spring.reference.ReferenceBeanManager;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import java.util.HashMap;
import java.util.Map;

/**
 * Dubbo Bean utilities class
 *
 * @since 2.7.6
 */
public interface DubboBeanUtils {

    /**
     * Register the common beans
     *
     * @param registry {@link BeanDefinitionRegistry}
     * @see ReferenceAnnotationBeanPostProcessor
     * @see DubboConfigDefaultPropertyValueBeanPostProcessor
     * @see DubboConfigAliasPostProcessor
     */
    static void registerCommonBeans(BeanDefinitionRegistry registry);

    /**
     * Register Infrastructure Bean
     *
     * @param beanDefinitionRegistry {@link BeanDefinitionRegistry}
     * @param beanType               the type of bean
     * @param beanName               the name of bean
     * @return if it's a first time to register, return <code>true</code>, or <code>false</code>
     */
    static boolean registerInfrastructureBean(BeanDefinitionRegistry beanDefinitionRegistry, String beanName, Class<?> beanType);

    /**
     * Register a placeholder configurer beans if not exists.
     * Call this method in BeanDefinitionRegistryPostProcessor,
     * in order to enable the registered BeanFactoryPostProcessor bean to be loaded and executed.
     *
     * @param beanFactory
     * @param registry
     * @see DubboInfraBeanRegisterPostProcessor
     * @see org.springframework.context.support.PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.List)
     */
    static void registerPlaceholderConfigurerBeanIfNotExists(ConfigurableListableBeanFactory beanFactory, BeanDefinitionRegistry registry);

    static boolean registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass, Map<String, Object> extraPropertyValues);

    static boolean checkBeanExists(ConfigurableListableBeanFactory beanFactory, Class<?> targetClass);

    static ReferenceAnnotationBeanPostProcessor getReferenceAnnotationBeanPostProcessor(AbstractBeanFactory beanFactory);

    static ReferenceAnnotationBeanPostProcessor getReferenceAnnotationBeanPostProcessor(ApplicationContext applicationContext);

    static DubboSpringInitContext getInitializationContext(BeanFactory beanFactory);

    static ApplicationModel getApplicationModel(BeanFactory beanFactory);

    static ModuleModel getModuleModel(BeanFactory beanFactory);
}

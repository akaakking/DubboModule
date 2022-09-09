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
import org.apache.dubbo.config.spring.context.annotation.DubboConfigConfigurationRegistrar;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import static com.alibaba.spring.util.BeanRegistrar.hasAlias;
import static org.springframework.util.ObjectUtils.nullSafeEquals;
import static org.springframework.util.StringUtils.hasText;

/**
 * A Post-Processor class to set the alias of Dubbo Config bean using its {@link AbstractConfig#getId()}
 *
 * @since 2.7.5
 */
public class DubboConfigAliasPostProcessor implements BeanDefinitionRegistryPostProcessor, BeanPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}

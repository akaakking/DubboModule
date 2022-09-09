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

import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.config.spring.util.DubboBeanUtils;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.ObjectUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Dubbo spring initialization entry point
 */
public class DubboSpringInitializer {

    public static void initialize(BeanDefinitionRegistry registry);

    public static boolean remove(BeanDefinitionRegistry registry);

    public static boolean remove(ApplicationContext springContext);

    static Map<BeanDefinitionRegistry, DubboSpringInitContext> getContextMap();

    static DubboSpringInitContext findBySpringContext(ApplicationContext applicationContext);

    private static void initContext(DubboSpringInitContext context, BeanDefinitionRegistry registry, ConfigurableListableBeanFactory beanFactory);

    private static String safeGetModelDesc(ScopeModel scopeModel);

    private static ConfigurableListableBeanFactory findBeanFactory(BeanDefinitionRegistry registry);

    private static void registerContextBeans(ConfigurableListableBeanFactory beanFactory, DubboSpringInitContext context);

    private static void registerSingleton(ConfigurableListableBeanFactory beanFactory, Object bean);

    private static DubboSpringInitContext findContextForApplication(ApplicationModel applicationModel);

    private static void customize(DubboSpringInitContext context);
}

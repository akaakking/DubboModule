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
import org.apache.dubbo.config.Constants;
import com.alibaba.spring.beans.factory.config.GenericBeanPostProcessorAdapter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import static com.alibaba.spring.util.ObjectUtils.of;
import static org.springframework.aop.support.AopUtils.getTargetClass;
import static org.springframework.beans.BeanUtils.getPropertyDescriptor;
import static org.springframework.util.ReflectionUtils.invokeMethod;

/**
 * The {@link BeanPostProcessor} class for the default property value of {@link AbstractConfig Dubbo's Config Beans}
 *
 * @since 2.7.6
 */
public class DubboConfigDefaultPropertyValueBeanPostProcessor extends GenericBeanPostProcessorAdapter<AbstractConfig> implements MergedBeanDefinitionPostProcessor, PriorityOrdered {

    @Override
    protected void processBeforeInitialization(AbstractConfig dubboConfigBean, String beanName) throws BeansException;

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName);

    protected void setPropertyIfAbsent(Object bean, String propertyName, String beanName);

    /**
     * @return Higher than {@link InitDestroyAnnotationBeanPostProcessor#getOrder()}
     * @see InitDestroyAnnotationBeanPostProcessor
     * @see CommonAnnotationBeanPostProcessor
     * @see PostConstruct
     */
    @Override
    public int getOrder();
}

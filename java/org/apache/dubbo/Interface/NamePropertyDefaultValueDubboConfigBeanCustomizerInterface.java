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
import org.apache.dubbo.config.spring.beans.factory.config.DubboConfigDefaultPropertyValueBeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import static com.alibaba.spring.util.ObjectUtils.of;
import static org.springframework.beans.BeanUtils.getPropertyDescriptor;

/**
 * {@link DubboConfigBeanCustomizer} for the default value for the "name" property that will be taken bean name
 * if absent.
 *
 * @since 2.6.6
 * @deprecated {@link DubboConfigDefaultPropertyValueBeanPostProcessor} instead
 */
@Deprecated
public class NamePropertyDefaultValueDubboConfigBeanCustomizerInterface implements DubboConfigBeanCustomizer {

    @Override
    public void customize(String beanName, AbstractConfig dubboConfigBean);

    @Override
    public int getOrder();
}

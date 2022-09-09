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

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.apache.dubbo.config.spring.ServiceBean;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import static com.alibaba.spring.util.AnnotationUtils.getAttribute;
import static org.apache.dubbo.config.spring.util.DubboAnnotationUtils.resolveInterfaceName;
import static org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes;

/**
 * Dubbo {@link Service @Service} Bean Builder
 *
 * @see Service
 * @see Reference
 * @see ServiceBean
 * @see ReferenceBean
 * @since 2.6.5
 */
public class ServiceBeanNameBuilder {

    /**
     * @param attributes
     * @param defaultInterfaceClass
     * @param environment
     * @return
     * @since 2.7.3
     */
    public static ServiceBeanNameBuilder create(AnnotationAttributes attributes, Class<?> defaultInterfaceClass, Environment environment);

    public static ServiceBeanNameBuilder create(Class<?> interfaceClass, Environment environment);

    public static ServiceBeanNameBuilder create(String interfaceClass, Environment environment);

    public static ServiceBeanNameBuilder create(Service service, Class<?> interfaceClass, Environment environment);

    public static ServiceBeanNameBuilder create(Reference reference, Class<?> interfaceClass, Environment environment);

    private static void append(StringBuilder builder, String value);

    public ServiceBeanNameBuilder group(String group);

    public ServiceBeanNameBuilder version(String version);

    public String build();
}

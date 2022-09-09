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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardMethodMetadata;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Spring Compatibility Utils for spring 3.x/4.x/5.x
 */
public class SpringCompatUtils {

    public static <T> T getPropertyValue(PropertyValues pvs, String propertyName);

    public static boolean isFactoryMethodMetadataEnabled();

    public static String getFactoryMethodReturnType(AnnotatedBeanDefinition annotatedBeanDefinition);

    public static MethodMetadata getFactoryMethodMetadata(AnnotatedBeanDefinition annotatedBeanDefinition);

    /**
     * Get the generic type of return type of the method.
     *
     * <pre>
     *  Source method:
     *  ReferenceBean&lt;DemoService> demoService()
     *
     *  Result: DemoService.class
     * </pre>
     *
     * @param factoryMethodMetadata
     * @return
     */
    public static Class getGenericTypeOfReturnType(MethodMetadata factoryMethodMetadata);
}

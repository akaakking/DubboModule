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

import org.apache.dubbo.common.utils.Assert;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.spring.Constants;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.apache.dubbo.config.spring.util.DubboAnnotationUtils;
import org.apache.dubbo.rpc.service.GenericService;
import com.alibaba.spring.util.AnnotationUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.ObjectUtils;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import static org.apache.dubbo.common.utils.StringUtils.join;

public class ReferenceBeanSupport {

    public static void convertReferenceProps(Map<String, Object> attributes, Class defaultInterfaceClass);

    public static String generateReferenceKey(Map<String, Object> attributes, ApplicationContext applicationContext);

    private static String convertToString(String key, Object obj);

    /**
     * Convert to raw props, without parsing nested config objects
     */
    public static Map<String, Object> convertPropertyValues(MutablePropertyValues propertyValues);

    private static Map<String, String> createParameterMap(ManagedMap managedMap);

    public static String generateReferenceKey(ReferenceBean referenceBean, ApplicationContext applicationContext);

    public static String generateReferenceKey(BeanDefinition beanDefinition, ApplicationContext applicationContext);

    public static Map<String, Object> getReferenceAttributes(ReferenceBean referenceBean);

    public static Map<String, Object> getReferenceAttributes(BeanDefinition beanDefinition);
}

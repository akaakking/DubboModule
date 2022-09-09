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

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.core.env.PropertyResolver;
import java.lang.annotation.Annotation;
import java.util.Map;
import static com.alibaba.spring.util.AnnotationUtils.getAttributes;

/**
 * {@link Annotation} {@link PropertyValues} Adapter
 *
 * @see Annotation
 * @see PropertyValues
 * @since 2.5.11
 */
public class AnnotationPropertyValuesAdapter implements PropertyValues {

    @Override
    public PropertyValue[] getPropertyValues();

    @Override
    public PropertyValue getPropertyValue(String propertyName);

    @Override
    public PropertyValues changesSince(PropertyValues old);

    @Override
    public boolean contains(String propertyName);

    @Override
    public boolean isEmpty();
}

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

import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.util.ObjectUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The utilities class for {@link Environment}
 *
 * @see Environment
 * @since 2.7.0
 */
public abstract class EnvironmentUtils {

    /**
     * Extras The properties from {@link ConfigurableEnvironment}
     *
     * @param environment {@link ConfigurableEnvironment}
     * @return Read-only Map
     */
    public static Map<String, Object> extractProperties(ConfigurableEnvironment environment);

    private static Map<String, Object> doExtraProperties(ConfigurableEnvironment environment);

    private static Map<String, PropertySource<?>> doGetPropertySources(ConfigurableEnvironment environment);

    private static void extract(String root, Map<String, PropertySource<?>> map, PropertySource<?> source);

    /**
     * Filters Dubbo Properties from {@link ConfigurableEnvironment}
     *
     * @param environment {@link ConfigurableEnvironment}
     * @return Read-only SortedMap
     */
    public static SortedMap<String, String> filterDubboProperties(ConfigurableEnvironment environment);
}

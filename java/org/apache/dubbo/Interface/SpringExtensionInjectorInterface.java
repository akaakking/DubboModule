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

import org.apache.dubbo.common.extension.ExtensionAccessor;
import org.apache.dubbo.common.extension.ExtensionInjector;
import org.apache.dubbo.common.extension.SPI;
import org.apache.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

/**
 * SpringExtensionInjector
 */
public class SpringExtensionInjector implements ExtensionInjector {

    @Deprecated
    public static void addApplicationContext(final ApplicationContext context);

    public static SpringExtensionInjector get(final ExtensionAccessor extensionAccessor);

    public ApplicationContext getContext();

    public void init(final ApplicationContext context);

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> type, String name);

    private <T> T getOptionalBean(final ListableBeanFactory beanFactory, final String name, final Class<T> type);

    private <T> T getOptionalBeanByType(final ListableBeanFactory beanFactory, final Class<T> type);
}

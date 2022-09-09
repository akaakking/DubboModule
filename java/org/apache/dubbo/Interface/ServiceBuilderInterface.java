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

import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.ServiceConfigBase;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a builder for build {@link ServiceConfigBase}.
 *
 * @since 2.7
 */
public class ServiceBuilder<U> extends AbstractServiceBuilder<ServiceConfig<U>, ServiceBuilder<U>> {

    public static <T> ServiceBuilder<T> newBuilder();

    public ServiceBuilder<U> id(String id);

    public ServiceBuilder<U> interfaceName(String interfaceName);

    public ServiceBuilder<U> interfaceClass(Class<?> interfaceClass);

    public ServiceBuilder<U> ref(U ref);

    public ServiceBuilder<U> path(String path);

    public ServiceBuilder<U> addMethod(MethodConfig method);

    public ServiceBuilder<U> addMethods(List<? extends MethodConfig> methods);

    public ServiceBuilder<U> provider(ProviderConfig provider);

    public ServiceBuilder<U> providerIds(String providerIds);

    public ServiceBuilder<U> generic(String generic);

    // @Override
    // public ServiceBuilder<U> mock(String mock) {
    // throw new IllegalArgumentException("mock doesn't support on provider side");
    // }
    // @Override
    // public ServiceBuilder<U> mock(Boolean mock) {
    // throw new IllegalArgumentException("mock doesn't support on provider side");
    // }
    public ServiceConfig<U> build();

    @Override
    protected ServiceBuilder<U> getThis();
}

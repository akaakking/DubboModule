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

import org.apache.dubbo.config.ProviderConfig;

/**
 * This is a builder for build {@link ProviderConfig}.
 *
 * @since 2.7
 */
public class ProviderBuilder extends AbstractServiceBuilder<ProviderConfig, ProviderBuilder> {

    public ProviderBuilder host(String host);

    public ProviderBuilder port(Integer port);

    public ProviderBuilder contextPath(String contextPath);

    public ProviderBuilder threadPool(String threadPool);

    public ProviderBuilder threads(Integer threads);

    public ProviderBuilder ioThreads(Integer ioThreads);

    public ProviderBuilder queues(Integer queues);

    public ProviderBuilder accepts(Integer accepts);

    public ProviderBuilder codec(String codec);

    public ProviderBuilder charset(String charset);

    public ProviderBuilder payload(Integer payload);

    public ProviderBuilder buffer(Integer buffer);

    public ProviderBuilder transporter(String transporter);

    public ProviderBuilder exchanger(String exchanger);

    public ProviderBuilder dispatcher(String dispatcher);

    public ProviderBuilder networker(String networker);

    public ProviderBuilder server(String server);

    public ProviderBuilder client(String client);

    public ProviderBuilder telnet(String telnet);

    public ProviderBuilder prompt(String prompt);

    public ProviderBuilder status(String status);

    public ProviderBuilder wait(Integer wait);

    public ProviderBuilder isDefault(Boolean isDefault);

    public ProviderConfig build();

    @Override
    protected ProviderBuilder getThis();
}

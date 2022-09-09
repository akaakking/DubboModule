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

import org.apache.dubbo.config.ProtocolConfig;
import java.util.Map;

/**
 * This is a builder for build {@link ProtocolConfig}.
 *
 * @since 2.7
 */
public class ProtocolBuilder extends AbstractBuilder<ProtocolConfig, ProtocolBuilder> {

    /**
     * whether it is a persistent connection
     */
    public static ProtocolBuilder newBuilder();

    public ProtocolBuilder id(String id);

    public ProtocolBuilder name(String name);

    public ProtocolBuilder host(String host);

    public ProtocolBuilder port(Integer port);

    public ProtocolBuilder contextpath(String contextpath);

    /**
     * @param path
     * @return ProtocolBuilder
     * @see ProtocolBuilder#contextpath(String)
     */
    @Deprecated
    public ProtocolBuilder path(String path);

    public ProtocolBuilder threadpool(String threadpool);

    public ProtocolBuilder corethreads(Integer corethreads);

    public ProtocolBuilder threads(Integer threads);

    public ProtocolBuilder iothreads(Integer iothreads);

    public ProtocolBuilder queues(Integer queues);

    public ProtocolBuilder accepts(Integer accepts);

    public ProtocolBuilder codec(String codec);

    public ProtocolBuilder serialization(String serialization);

    public ProtocolBuilder charset(String charset);

    public ProtocolBuilder payload(Integer payload);

    public ProtocolBuilder buffer(Integer buffer);

    public ProtocolBuilder heartbeat(Integer heartbeat);

    public ProtocolBuilder accesslog(String accesslog);

    public ProtocolBuilder transporter(String transporter);

    public ProtocolBuilder exchanger(String exchanger);

    public ProtocolBuilder dispatcher(String dispatcher);

    /**
     * @param dispather
     * @return ProtocolBuilder
     * @see ProtocolBuilder#dispatcher(String)
     */
    @Deprecated
    public ProtocolBuilder dispather(String dispather);

    public ProtocolBuilder networker(String networker);

    public ProtocolBuilder server(String server);

    public ProtocolBuilder client(String client);

    public ProtocolBuilder telnet(String telnet);

    public ProtocolBuilder prompt(String prompt);

    public ProtocolBuilder status(String status);

    public ProtocolBuilder register(Boolean register);

    public ProtocolBuilder keepAlive(Boolean keepAlive);

    public ProtocolBuilder optimizer(String optimizer);

    public ProtocolBuilder extension(String extension);

    public ProtocolBuilder appendParameter(String key, String value);

    public ProtocolBuilder appendParameters(Map<String, String> appendParameters);

    public ProtocolBuilder isDefault(Boolean isDefault);

    public ProtocolConfig build();

    @Override
    protected ProtocolBuilder getThis();
}

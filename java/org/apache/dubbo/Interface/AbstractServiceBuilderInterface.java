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

import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.AbstractServiceConfig;
import org.apache.dubbo.config.ProtocolConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBuilder
 *
 * @since 2.7
 */
public abstract class AbstractServiceBuilderInterface<T extends AbstractServiceConfig, B extends AbstractServiceBuilder<T, B>> extends AbstractInterfaceBuilder<T, B> {

    public B version(String version);

    public B group(String group);

    public B deprecated(Boolean deprecated);

    public B delay(Integer delay);

    public B export(Boolean export);

    public B weight(Integer weight);

    public B document(String document);

    public B dynamic(Boolean dynamic);

    public B token(String token);

    public B token(Boolean token);

    public B accesslog(String accesslog);

    public B accesslog(Boolean accesslog);

    public B addProtocols(List<ProtocolConfig> protocols);

    public B addProtocol(ProtocolConfig protocol);

    public B protocolIds(String protocolIds);

    public B executes(Integer executes);

    public B register(Boolean register);

    public B warmup(Integer warmup);

    public B serialization(String serialization);

    @Override
    public void build(T instance);
}

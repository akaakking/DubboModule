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
import org.apache.dubbo.config.AbstractMethodConfig;
import java.util.Map;

/**
 * AbstractBuilder
 *
 * @since 2.7
 */
public abstract class AbstractMethodBuilder<T extends AbstractMethodConfig, B extends AbstractMethodBuilder<T, B>> extends AbstractBuilder<T, B> {

    public B timeout(Integer timeout);

    public B retries(Integer retries);

    public B actives(Integer actives);

    public B loadbalance(String loadbalance);

    public B async(Boolean async);

    public B sent(Boolean sent);

    public B mock(String mock);

    public B mock(Boolean mock);

    public B merger(String merger);

    public B cache(String cache);

    public B validation(String validation);

    public B appendParameters(Map<String, String> appendParameters);

    public B appendParameter(String key, String value);

    public B forks(Integer forks);

    @Override
    @SuppressWarnings("unchecked")
    public void build(T instance);
}

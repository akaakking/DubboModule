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
import org.apache.dubbo.config.AbstractReferenceConfig;

/**
 * AbstractBuilder
 *
 * @since 2.7
 */
public abstract class AbstractReferenceBuilderInterface<T extends AbstractReferenceConfig, B extends AbstractReferenceBuilder<T, B>> extends AbstractInterfaceBuilder<T, B> {

    public B check(Boolean check);

    public B init(Boolean init);

    public B generic(String generic);

    public B generic(Boolean generic);

    /**
     * @param injvm
     * @see AbstractInterfaceBuilder#scope(String)
     * @deprecated instead, use the parameter <b>scope</b> to judge if it's in jvm, scope=local
     */
    @Deprecated
    public B injvm(Boolean injvm);

    public B lazy(Boolean lazy);

    public B reconnect(String reconnect);

    public B sticky(Boolean sticky);

    public B version(String version);

    public B group(String group);

    @Override
    public void build(T instance);
}

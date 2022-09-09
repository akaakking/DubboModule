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

import org.apache.dubbo.config.ArgumentConfig;
import org.apache.dubbo.config.MethodConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a builder for build {@link MethodConfig}.
 *
 * @since 2.7
 */
public class MethodBuilder extends AbstractMethodBuilder<MethodConfig, MethodBuilder> {

    public MethodBuilder name(String name);

    public MethodBuilder stat(Integer stat);

    public MethodBuilder retry(Boolean retry);

    public MethodBuilder reliable(Boolean reliable);

    public MethodBuilder executes(Integer executes);

    public MethodBuilder deprecated(Boolean deprecated);

    public MethodBuilder sticky(Boolean sticky);

    public MethodBuilder isReturn(Boolean isReturn);

    public MethodBuilder oninvoke(Object oninvoke);

    public MethodBuilder oninvokeMethod(String oninvokeMethod);

    public MethodBuilder onreturn(Object onreturn);

    public MethodBuilder onreturnMethod(String onreturnMethod);

    public MethodBuilder onthrow(Object onthrow);

    public MethodBuilder onthrowMethod(String onthrowMethod);

    public MethodBuilder addArguments(List<? extends ArgumentConfig> arguments);

    public MethodBuilder addArgument(ArgumentConfig argument);

    public MethodBuilder service(String service);

    public MethodBuilder serviceId(String serviceId);

    public MethodConfig build();

    @Override
    protected MethodBuilder getThis();
}

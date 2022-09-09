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

import org.apache.dubbo.common.BaseServiceMetadata;
import org.apache.dubbo.common.config.ReferenceCache;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import java.util.ArrayList;
import java.util.List;

/**
 * A impl of ReferenceCache for Application
 */
public class CompositeReferenceCacheInterface implements ReferenceCache {

    @Override
    public <T> T get(ReferenceConfigBase<T> referenceConfig);

    @Override
    public <T> T get(String key, Class<T> type);

    @Override
    public <T> T get(String key);

    @Override
    public <T> List<T> getAll(Class<T> type);

    @Override
    public <T> T get(Class<T> type);

    @Override
    public void destroy(String key, Class<?> type);

    @Override
    public void destroy(Class<?> type);

    @Override
    public <T> void destroy(ReferenceConfigBase<T> referenceConfig);

    @Override
    public void destroyAll();
}

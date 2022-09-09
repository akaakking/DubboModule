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

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ScopeModelDestroyListener;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A cleaner to release resources of framework model
 */
public class FrameworkModelCleaner implements ScopeModelDestroyListener<FrameworkModel> {

    @Override
    public boolean isProtocol();

    @Override
    public void onDestroy(FrameworkModel frameworkModel);

    /**
     * Destroy all framework resources.
     */
    private void destroyFrameworkResources(FrameworkModel frameworkModel);

    /**
     * Destroy all the protocols.
     */
    private void destroyProtocols(FrameworkModel frameworkModel);
}

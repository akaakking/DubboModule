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

import org.apache.dubbo.common.deploy.ApplicationDeployListener;
import org.apache.dubbo.common.lang.Prioritized;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.registry.client.metadata.MetadataServiceDelegation;
import org.apache.dubbo.rpc.model.ApplicationModel;
import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_METADATA_STORAGE_TYPE;
import static org.apache.dubbo.common.constants.CommonConstants.REMOTE_METADATA_STORAGE_TYPE;

public class ExporterDeployListener implements ApplicationDeployListener, Prioritized {

    @Override
    public void onStarting(ApplicationModel scopeModel);

    @Override
    public synchronized void onStarted(ApplicationModel applicationModel);

    @Override
    public synchronized void onStopping(ApplicationModel scopeModel);

    private String getMetadataType(ApplicationModel applicationModel);

    public ConfigurableMetadataServiceExporter getMetadataServiceExporter();

    public void setMetadataServiceExporter(ConfigurableMetadataServiceExporter metadataServiceExporter);

    @Override
    public synchronized void onModuleStarted(ApplicationModel applicationModel);

    @Override
    public synchronized void onStopped(ApplicationModel scopeModel);

    @Override
    public void onFailure(ApplicationModel scopeModel, Throwable cause);

    @Override
    public int getPriority();
}

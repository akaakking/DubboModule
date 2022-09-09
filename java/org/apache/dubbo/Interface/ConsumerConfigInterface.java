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
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ModuleModel;
import static org.apache.dubbo.common.constants.CommonConstants.MESH_ENABLE;
import static org.apache.dubbo.common.constants.CommonConstants.REFER_BACKGROUND_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REFER_THREAD_NUM_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.URL_MERGE_PROCESSOR_KEY;

/**
 * The service consumer default configuration
 *
 * @export
 */
public class ConsumerConfig extends AbstractReferenceConfig {

    @Override
    public void setTimeout(Integer timeout);

    public String getThreadpool();

    public void setThreadpool(String threadpool);

    public Integer getCorethreads();

    public void setCorethreads(Integer corethreads);

    public Integer getThreads();

    public void setThreads(Integer threads);

    public Integer getQueues();

    public void setQueues(Integer queues);

    public Integer getShareconnections();

    public void setShareconnections(Integer shareconnections);

    @Parameter(key = URL_MERGE_PROCESSOR_KEY)
    public String getUrlMergeProcessor();

    public void setUrlMergeProcessor(String urlMergeProcessor);

    @Parameter(key = REFER_THREAD_NUM_KEY, excluded = true)
    public Integer getReferThreadNum();

    public void setReferThreadNum(Integer referThreadNum);

    @Deprecated
    @Parameter(key = REFER_BACKGROUND_KEY, excluded = true)
    public Boolean getReferBackground();

    /**
     * Whether refer should run in background or not.
     *
     * @deprecated replace with {@link ModuleConfig#setBackground(Boolean)}
     * @see ModuleConfig#setBackground(Boolean)
     */
    @Deprecated
    public void setReferBackground(Boolean referBackground);

    @Parameter(key = MESH_ENABLE)
    public Boolean getMeshEnable();

    public void setMeshEnable(Boolean meshEnable);
}

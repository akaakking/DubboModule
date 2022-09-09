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

import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ModuleModel;
import java.util.ArrayList;
import java.util.Arrays;
import static org.apache.dubbo.common.constants.CommonConstants.EXPORT_BACKGROUND_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.EXPORT_THREAD_NUM_KEY;

/**
 * The service provider default configuration
 *
 * @export
 * @see org.apache.dubbo.config.ProtocolConfig
 * @see ServiceConfigBase
 */
public class ProviderConfig extends AbstractServiceConfig {

    // ======== protocol default values, it'll take effect when protocol's attributes are not set ========
    @Deprecated
    public void setProtocol(String protocol);

    @Parameter(excluded = true)
    public String getHost();

    public void setHost(String host);

    @Parameter(excluded = true)
    public Integer getPort();

    @Deprecated
    public void setPort(Integer port);

    @Deprecated
    @Parameter(excluded = true, attribute = false)
    public String getPath();

    @Deprecated
    public void setPath(String path);

    @Parameter(excluded = true)
    public String getContextpath();

    public void setContextpath(String contextpath);

    public String getThreadpool();

    public void setThreadpool(String threadpool);

    public String getThreadname();

    public void setThreadname(String threadname);

    public Integer getThreads();

    public void setThreads(Integer threads);

    public Integer getIothreads();

    public void setIothreads(Integer iothreads);

    public Integer getAlive();

    public void setAlive(Integer alive);

    public Integer getQueues();

    public void setQueues(Integer queues);

    public Integer getAccepts();

    public void setAccepts(Integer accepts);

    public String getCodec();

    public void setCodec(String codec);

    public String getCharset();

    public void setCharset(String charset);

    public Integer getPayload();

    public void setPayload(Integer payload);

    public Integer getBuffer();

    public void setBuffer(Integer buffer);

    public String getServer();

    public void setServer(String server);

    public String getClient();

    public void setClient(String client);

    public String getTelnet();

    public void setTelnet(String telnet);

    @Parameter(escaped = true)
    public String getPrompt();

    public void setPrompt(String prompt);

    public String getStatus();

    public void setStatus(String status);

    public String getTransporter();

    public void setTransporter(String transporter);

    public String getExchanger();

    public void setExchanger(String exchanger);

    /**
     * typo, switch to use {@link #getDispatcher()}
     *
     * @deprecated {@link #getDispatcher()}
     */
    @Deprecated
    @Parameter(excluded = true, attribute = false)
    public String getDispather();

    /**
     * typo, switch to use {@link #getDispatcher()}
     *
     * @deprecated {@link #setDispatcher(String)}
     */
    @Deprecated
    public void setDispather(String dispather);

    public String getDispatcher();

    public void setDispatcher(String dispatcher);

    public String getNetworker();

    public void setNetworker(String networker);

    public Integer getWait();

    public void setWait(Integer wait);

    @Deprecated
    @Parameter(key = EXPORT_THREAD_NUM_KEY, excluded = true)
    public Integer getExportThreadNum();

    @Deprecated
    public void setExportThreadNum(Integer exportThreadNum);

    /**
     * @deprecated replace with {@link ModuleConfig#getBackground()}
     * @see ModuleConfig#getBackground()
     */
    @Deprecated
    @Parameter(key = EXPORT_BACKGROUND_KEY, excluded = true)
    public Boolean getExportBackground();

    /**
     * Whether export should run in background or not.
     *
     * @deprecated replace with {@link ModuleConfig#setBackground(Boolean)}
     * @see ModuleConfig#setBackground(Boolean)
     */
    @Deprecated
    public void setExportBackground(Boolean exportBackground);
}

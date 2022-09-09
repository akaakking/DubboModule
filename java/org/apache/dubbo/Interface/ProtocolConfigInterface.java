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
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.Map;
import static org.apache.dubbo.common.constants.CommonConstants.DUBBO_PROTOCOL;
import static org.apache.dubbo.common.constants.CommonConstants.SSL_ENABLED_KEY;

/**
 * ProtocolConfig
 *
 * @export
 */
public class ProtocolConfig extends AbstractConfig {

    /**
     * whether it is a persistent connection
     */
    @Override
    protected void checkDefault();

    @Parameter(excluded = true)
    public String getName();

    public final void setName(String name);

    @Parameter(excluded = true)
    public String getHost();

    public void setHost(String host);

    @Parameter(excluded = true)
    public Integer getPort();

    public final void setPort(Integer port);

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

    public Integer getCorethreads();

    public void setCorethreads(Integer corethreads);

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

    public String getSerialization();

    public void setSerialization(String serialization);

    public String getCharset();

    public void setCharset(String charset);

    public Integer getPayload();

    public void setPayload(Integer payload);

    public Integer getBuffer();

    public void setBuffer(Integer buffer);

    public Integer getHeartbeat();

    public void setHeartbeat(Integer heartbeat);

    public String getServer();

    public void setServer(String server);

    public String getClient();

    public void setClient(String client);

    public String getAccesslog();

    public void setAccesslog(String accesslog);

    public String getTelnet();

    public void setTelnet(String telnet);

    @Parameter(escaped = true)
    public String getPrompt();

    public void setPrompt(String prompt);

    public String getStatus();

    public void setStatus(String status);

    public Boolean isRegister();

    public void setRegister(Boolean register);

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

    public Map<String, String> getParameters();

    public void setParameters(Map<String, String> parameters);

    @Parameter(key = SSL_ENABLED_KEY)
    public Boolean getSslEnabled();

    public void setSslEnabled(Boolean sslEnabled);

    public Boolean getKeepAlive();

    public void setKeepAlive(Boolean keepAlive);

    public String getOptimizer();

    public void setOptimizer(String optimizer);

    public String getExtension();

    public void setExtension(String extension);

    @Override
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();
}

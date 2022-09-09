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

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.url.component.ServiceConfigURL;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.HashMap;
import java.util.Map;
import static org.apache.dubbo.common.constants.CommonConstants.CYCLE_REPORT_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.METADATA;
import static org.apache.dubbo.common.constants.CommonConstants.PROTOCOL_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REPORT_DEFINITION_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REPORT_METADATA_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.RETRY_PERIOD_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.RETRY_TIMES_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.SYNC_REPORT_KEY;
import static org.apache.dubbo.common.constants.RemotingConstants.BACKUP_KEY;
import static org.apache.dubbo.common.utils.PojoUtils.updatePropertyIfAbsent;
import static org.apache.dubbo.common.utils.StringUtils.isEmpty;

/**
 * MetadataReportConfig
 *
 * @export
 */
public class MetadataReportConfig extends AbstractConfig {

    public URL toUrl() throws IllegalArgumentException;

    public String getProtocol();

    public void setProtocol(String protocol);

    @Parameter(excluded = true)
    public String getAddress();

    public void setAddress(String address);

    public Integer getPort();

    public void setPort(Integer port);

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    public Integer getTimeout();

    public void setTimeout(Integer timeout);

    public Map<String, String> getParameters();

    public void setParameters(Map<String, String> parameters);

    @Parameter(key = RETRY_TIMES_KEY)
    public Integer getRetryTimes();

    public void setRetryTimes(Integer retryTimes);

    @Parameter(key = RETRY_PERIOD_KEY)
    public Integer getRetryPeriod();

    public void setRetryPeriod(Integer retryPeriod);

    @Parameter(key = CYCLE_REPORT_KEY)
    public Boolean getCycleReport();

    public void setCycleReport(Boolean cycleReport);

    @Parameter(key = SYNC_REPORT_KEY)
    public Boolean getSyncReport();

    public void setSyncReport(Boolean syncReport);

    @Override
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();

    public String getGroup();

    public void setGroup(String group);

    public Boolean getCluster();

    public void setCluster(Boolean cluster);

    public String getRegistry();

    public void setRegistry(String registry);

    public String getFile();

    public void setFile(String file);

    public void updateParameters(Map<String, String> parameters);

    public Boolean isCheck();

    public void setCheck(Boolean check);

    @Parameter(key = REPORT_METADATA_KEY)
    public Boolean getReportMetadata();

    public void setReportMetadata(Boolean reportMetadata);

    @Parameter(key = REPORT_DEFINITION_KEY)
    public Boolean getReportDefinition();

    public void setReportDefinition(Boolean reportDefinition);
}

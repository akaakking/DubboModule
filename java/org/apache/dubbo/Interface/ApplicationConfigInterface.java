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

import org.apache.dubbo.common.compiler.support.AdaptiveCompiler;
import org.apache.dubbo.common.infra.InfraAdapter;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.apache.dubbo.common.constants.CommonConstants.APPLICATION_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.APPLICATION_PROTOCOL_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.APPLICATION_VERSION_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.DUBBO;
import static org.apache.dubbo.common.constants.CommonConstants.DUMP_DIRECTORY;
import static org.apache.dubbo.common.constants.CommonConstants.HOST_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.LIVENESS_PROBE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.METADATA_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.METADATA_SERVICE_PORT_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.METADATA_SERVICE_PROTOCOL_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.READINESS_PROBE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.REGISTRY_LOCAL_FILE_CACHE_ENABLED;
import static org.apache.dubbo.common.constants.CommonConstants.SHUTDOWN_WAIT_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.STARTUP_PROBE;
import static org.apache.dubbo.common.constants.QosConstants.ACCEPT_FOREIGN_IP;
import static org.apache.dubbo.common.constants.QosConstants.ACCEPT_FOREIGN_IP_COMPATIBLE;
import static org.apache.dubbo.common.constants.QosConstants.QOS_ENABLE;
import static org.apache.dubbo.common.constants.QosConstants.QOS_ENABLE_COMPATIBLE;
import static org.apache.dubbo.common.constants.QosConstants.QOS_HOST;
import static org.apache.dubbo.common.constants.QosConstants.QOS_HOST_COMPATIBLE;
import static org.apache.dubbo.common.constants.QosConstants.QOS_PORT;
import static org.apache.dubbo.common.constants.QosConstants.QOS_PORT_COMPATIBLE;
import static org.apache.dubbo.common.constants.RegistryConstants.ENABLE_EMPTY_PROTECTION_KEY;
import static org.apache.dubbo.common.constants.RegistryConstants.REGISTER_MODE_KEY;
import static org.apache.dubbo.config.Constants.DEVELOPMENT_ENVIRONMENT;
import static org.apache.dubbo.config.Constants.PRODUCTION_ENVIRONMENT;
import static org.apache.dubbo.config.Constants.TEST_ENVIRONMENT;

/**
 * The application info
 *
 * @export
 */
public class ApplicationConfigInterface extends AbstractConfig {

    @Parameter(key = APPLICATION_KEY, required = true)
    public String getName();

    public void setName(String name);

    @Parameter(key = APPLICATION_VERSION_KEY)
    public String getVersion();

    public void setVersion(String version);

    public String getOwner();

    public void setOwner(String owner);

    public String getOrganization();

    public void setOrganization(String organization);

    public String getArchitecture();

    public void setArchitecture(String architecture);

    public String getEnvironment();

    public void setEnvironment(String environment);

    public void setRegistry(RegistryConfig registry);

    @SuppressWarnings({ "unchecked" })
    public void setRegistries(List<? extends RegistryConfig> registries);

    @Parameter(excluded = true)
    public String getRegistryIds();

    public void setRegistryIds(String registryIds);

    public void setMonitor(String monitor);

    public void setMonitor(MonitorConfig monitor);

    public String getCompiler();

    public void setCompiler(String compiler);

    public String getLogger();

    public void setLogger(String logger);

    @Parameter(key = DUMP_DIRECTORY)
    public String getDumpDirectory();

    public void setDumpDirectory(String dumpDirectory);

    @Parameter(key = QOS_ENABLE)
    public Boolean getQosEnable();

    public void setQosEnable(Boolean qosEnable);

    @Parameter(key = QOS_HOST)
    public String getQosHost();

    public void setQosHost(String qosHost);

    @Parameter(key = QOS_PORT)
    public Integer getQosPort();

    public void setQosPort(Integer qosPort);

    @Parameter(key = ACCEPT_FOREIGN_IP)
    public Boolean getQosAcceptForeignIp();

    public void setQosAcceptForeignIp(Boolean qosAcceptForeignIp);

    /**
     * The format is the same as the springboot, including: getQosEnableCompatible(), getQosPortCompatible(), getQosAcceptForeignIpCompatible().
     *
     * @return
     */
    @Parameter(key = QOS_ENABLE_COMPATIBLE, excluded = true, attribute = false)
    public Boolean getQosEnableCompatible();

    public void setQosEnableCompatible(Boolean qosEnable);

    @Parameter(key = QOS_HOST_COMPATIBLE, excluded = true, attribute = false)
    public String getQosHostCompatible();

    public void setQosHostCompatible(String qosHost);

    @Parameter(key = QOS_PORT_COMPATIBLE, excluded = true, attribute = false)
    public Integer getQosPortCompatible();

    public void setQosPortCompatible(Integer qosPort);

    @Parameter(key = ACCEPT_FOREIGN_IP_COMPATIBLE, excluded = true, attribute = false)
    public Boolean getQosAcceptForeignIpCompatible();

    public void setQosAcceptForeignIpCompatible(Boolean qosAcceptForeignIp);

    public Map<String,String> getParameters();

    public void setParameters(Map<String, String> parameters);

    public String getShutwait();

    public void setShutwait(String shutwait);

    @Parameter(excluded = true)
    public String getHostname();

    @Override
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();

    @Parameter(key = METADATA_KEY)
    public String getMetadataType();

    public void setMetadataType(String metadataType);

    public Boolean getRegisterConsumer();

    public void setRegisterConsumer(Boolean registerConsumer);

    public String getRepository();

    public void setRepository(String repository);

    @Parameter(key = REGISTRY_LOCAL_FILE_CACHE_ENABLED)
    public Boolean getEnableFileCache();

    public void setEnableFileCache(Boolean enableFileCache);

    @Parameter(key = REGISTER_MODE_KEY)
    public String getRegisterMode();

    public void setRegisterMode(String registerMode);

    @Parameter(key = ENABLE_EMPTY_PROTECTION_KEY)
    public Boolean getEnableEmptyProtection();

    public void setEnableEmptyProtection(Boolean enableEmptyProtection);

    @Parameter(excluded = true, key = APPLICATION_PROTOCOL_KEY)
    public String getProtocol();

    public void setProtocol(String protocol);

    @Parameter(key = METADATA_SERVICE_PORT_KEY)
    public Integer getMetadataServicePort();

    public void setMetadataServicePort(Integer metadataServicePort);

    @Parameter(key = METADATA_SERVICE_PROTOCOL_KEY)
    public String getMetadataServiceProtocol();

    public void setMetadataServiceProtocol(String metadataServiceProtocol);

    @Parameter(key = LIVENESS_PROBE_KEY)
    public String getLivenessProbe();

    public void setLivenessProbe(String livenessProbe);

    @Parameter(key = READINESS_PROBE_KEY)
    public String getReadinessProbe();

    public void setReadinessProbe(String readinessProbe);

    @Parameter(key = STARTUP_PROBE)
    public String getStartupProbe();

    public void setStartupProbe(String startupProbe);

    @Override
    public void refresh();
}

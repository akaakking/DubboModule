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

import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Builder for ReferenceBean, used to return ReferenceBean instance in Java-config @Bean method,
 * equivalent to {@link DubboReference} annotation.
 * </p>
 *
 * <p>
 * <b>It is recommended to use {@link DubboReference} on the @Bean method in the Java-config class.</b>
 * </p>
 *
 * Step 1: Register ReferenceBean in Java-config class:
 * <pre class="code">
 * &#64;Configuration
 * public class ReferenceConfiguration {
 *
 *     &#64;Bean
 *     public ReferenceBean&lt;HelloService&gt; helloService() {
 *         return new ReferenceBeanBuilder()
 *                 .setGroup("demo")
 *                 .build();
 *     }
 *
 *     &#64;Bean
 *     public ReferenceBean&lt;HelloService&gt; helloService2() {
 *         return new ReferenceBean();
 *     }
 *
 *     &#64;Bean
 *     public ReferenceBean&lt;GenericService&gt; genericHelloService() {
 *         return new ReferenceBeanBuilder()
 *                 .setGroup("demo")
 *                 .setInterface(HelloService.class)
 *                 .build();
 *     }
 *
 * }
 * </pre>
 *
 * Step 2: Inject ReferenceBean by @Autowired
 * <pre class="code">
 * public class FooController {
 *     &#64;Autowired
 *     private HelloService helloService;
 *
 *     &#64;Autowired
 *     private GenericService genericHelloService;
 * }
 * </pre>
 *
 * @see org.apache.dubbo.config.annotation.DubboReference
 * @see org.apache.dubbo.config.spring.ReferenceBean
 */
public class ReferenceBeanBuilder {

    public <T> ReferenceBean<T> build();

    public ReferenceBeanBuilder setServices(String services);

    public ReferenceBeanBuilder setInterface(String interfaceName);

    public ReferenceBeanBuilder setInterface(Class interfaceClass);

    public ReferenceBeanBuilder setClient(String client);

    public ReferenceBeanBuilder setUrl(String url);

    public ReferenceBeanBuilder setConsumer(ConsumerConfig consumer);

    public ReferenceBeanBuilder setConsumer(String consumer);

    public ReferenceBeanBuilder setProtocol(String protocol);

    public ReferenceBeanBuilder setCheck(Boolean check);

    public ReferenceBeanBuilder setInit(Boolean init);

    // @Deprecated
    public ReferenceBeanBuilder setGeneric(Boolean generic);

    /**
     * @param injvm
     * @deprecated instead, use the parameter <b>scope</b> to judge if it's in jvm, scope=local
     */
    @Deprecated
    public ReferenceBeanBuilder setInjvm(Boolean injvm);

    public ReferenceBeanBuilder setListener(String listener);

    public ReferenceBeanBuilder setLazy(Boolean lazy);

    public ReferenceBeanBuilder setOnconnect(String onconnect);

    public ReferenceBeanBuilder setOndisconnect(String ondisconnect);

    public ReferenceBeanBuilder setReconnect(String reconnect);

    public ReferenceBeanBuilder setSticky(Boolean sticky);

    public ReferenceBeanBuilder setVersion(String version);

    public ReferenceBeanBuilder setGroup(String group);

    public ReferenceBeanBuilder setProvidedBy(String providedBy);

    public ReferenceBeanBuilder setProviderPort(Integer providerPort);

    // public ReferenceBeanBuilder setRouter(String router) {
    // attributes.put(ReferenceAttributes.ROUTER, router);
    // return this;
    // }
    public ReferenceBeanBuilder setStub(String stub);

    public ReferenceBeanBuilder setCluster(String cluster);

    public ReferenceBeanBuilder setProxy(String proxy);

    public ReferenceBeanBuilder setConnections(Integer connections);

    public ReferenceBeanBuilder setFilter(String filter);

    public ReferenceBeanBuilder setLayer(String layer);

    // @Deprecated
    // public ReferenceBeanBuilder setApplication(ApplicationConfig application) {
    // attributes.put(ReferenceAttributes.APPLICATION, application);
    // return this;
    // }
    // @Deprecated
    // public ReferenceBeanBuilder setModule(ModuleConfig module) {
    // attributes.put(ReferenceAttributes.MODULE, module);
    // return this;
    // }
    public ReferenceBeanBuilder setRegistry(String[] registryIds);

    public ReferenceBeanBuilder setRegistry(RegistryConfig registry);

    public ReferenceBeanBuilder setRegistries(List<? extends RegistryConfig> registries);

    public ReferenceBeanBuilder setMethods(List<? extends MethodConfig> methods);

    @Deprecated
    public ReferenceBeanBuilder setMonitor(MonitorConfig monitor);

    @Deprecated
    public ReferenceBeanBuilder setMonitor(String monitor);

    public ReferenceBeanBuilder setOwner(String owner);

    public ReferenceBeanBuilder setCallbacks(Integer callbacks);

    public ReferenceBeanBuilder setScope(String scope);

    public ReferenceBeanBuilder setTag(String tag);

    public ReferenceBeanBuilder setTimeout(Integer timeout);

    public ReferenceBeanBuilder setRetries(Integer retries);

    public ReferenceBeanBuilder setLoadBalance(String loadbalance);

    public ReferenceBeanBuilder setAsync(Boolean async);

    public ReferenceBeanBuilder setActives(Integer actives);

    public ReferenceBeanBuilder setSent(Boolean sent);

    public ReferenceBeanBuilder setMock(String mock);

    public ReferenceBeanBuilder setMerger(String merger);

    public ReferenceBeanBuilder setCache(String cache);

    public ReferenceBeanBuilder setValidation(String validation);

    public ReferenceBeanBuilder setParameters(Map<String, String> parameters);
    // public ReferenceBeanBuilder setAuth(Boolean auth) {
    // attributes.put(ReferenceAttributes.AUTH, auth);
    // return this;
    // }
    // 
    // public ReferenceBeanBuilder setForks(Integer forks) {
    // attributes.put(ReferenceAttributes.FORKS, forks);
    // return this;
    // }
    // 
    // @Deprecated
    // public ReferenceBeanBuilder setConfigCenter(ConfigCenterConfig configCenter) {
    // attributes.put(ReferenceAttributes.CONFIG_CENTER, configCenter);
    // return this;
    // }
    // 
    // @Deprecated
    // public ReferenceBeanBuilder setMetadataReportConfig(MetadataReportConfig metadataReportConfig) {
    // attributes.put(ReferenceAttributes.METADATA_REPORT_CONFIG, metadataReportConfig);
    // return this;
    // }
    // 
    // @Deprecated
    // public ReferenceBeanBuilder setMetrics(MetricsConfig metrics) {
    // attributes.put(ReferenceAttributes.METRICS, metrics);
    // return this;
    // }
}

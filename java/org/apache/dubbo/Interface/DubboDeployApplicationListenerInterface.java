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

import static org.springframework.util.ObjectUtils.nullSafeEquals;
import java.util.concurrent.Future;
import org.apache.dubbo.common.deploy.DeployListenerAdapter;
import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.common.deploy.ModuleDeployer;
import org.apache.dubbo.common.logger.ErrorTypeAwareLogger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.Assert;
import org.apache.dubbo.config.spring.context.event.DubboApplicationStateEvent;
import org.apache.dubbo.config.spring.util.DubboBeanUtils;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModelConstants;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * An ApplicationListener to control Dubbo application.
 */
public class DubboDeployApplicationListener implements ApplicationListener<ApplicationContextEvent>, ApplicationContextAware, Ordered {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

    private void publishEvent(DeployState state);

    private void publishEvent(DeployState state, Throwable cause);

    @Override
    public void onApplicationEvent(ApplicationContextEvent event);

    private void onContextRefreshedEvent(ContextRefreshedEvent event);

    private void onContextClosedEvent(ContextClosedEvent event);

    @Override
    public int getOrder();
}

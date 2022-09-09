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

import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.config.ArgumentConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.ModuleConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.spring.beans.factory.annotation.AnnotationPropertyValuesAdapter;
import org.apache.dubbo.config.spring.util.DubboAnnotationUtils;
import org.apache.dubbo.config.spring.util.DubboBeanUtils;
import org.apache.dubbo.rpc.model.ModuleModel;
import com.alibaba.spring.util.AnnotationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.DataBinder;
import java.util.Map;
import static com.alibaba.spring.util.AnnotationUtils.getAttribute;
import static com.alibaba.spring.util.ObjectUtils.of;

/**
 * {@link ReferenceConfig} Creator for @{@link DubboReference}
 *
 * @since 3.0
 */
public class ReferenceCreator {

    public final ReferenceConfig build() throws Exception;

    protected void configureBean(ReferenceConfig referenceConfig) throws Exception;

    private void configureMonitorConfig(ReferenceConfig configBean);

    // private void configureApplicationConfig(ReferenceConfig configBean) {
    // String applicationConfigId = getAttribute(attributes, "application");
    // if (StringUtils.hasText(applicationConfigId)) {
    // ApplicationConfig applicationConfig = getConfig(applicationConfigId, ApplicationConfig.class);
    // configBean.setApplication(applicationConfig);
    // }
    // }
    private void configureModuleConfig(ReferenceConfig configBean);

    private void configureConsumerConfig(ReferenceConfig<?> referenceBean);

    private <T extends AbstractConfig> T getConfig(String configIdOrName, Class<T> configType);

    protected void populateBean(ReferenceConfig referenceConfig);

    private MethodConfig createMethodConfig(Map<String, Object> methodAttributes, DefaultConversionService conversionService);

    public static ReferenceCreator create(Map<String, Object> attributes, ApplicationContext applicationContext);

    public ReferenceCreator defaultInterfaceClass(Class<?> interfaceClass);
}

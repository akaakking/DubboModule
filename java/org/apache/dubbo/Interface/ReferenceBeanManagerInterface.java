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

import org.apache.dubbo.common.utils.Assert;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.apache.dubbo.config.spring.util.DubboBeanUtils;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReferenceBeanManager implements ApplicationContextAware {

    public void addReference(ReferenceBean referenceBean) throws Exception;

    private String getReferenceKeyByBeanName(String referenceBeanName);

    public void registerReferenceKeyAndBeanName(String referenceKey, String referenceBeanNameOrAlias);

    public ReferenceBean getById(String referenceBeanNameOrAlias);

    // convert reference name/alias to referenceBeanName
    private String transformName(String referenceBeanNameOrAlias);

    public List<String> getBeanNamesByKey(String key);

    public Collection<ReferenceBean> getReferences();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

    /**
     * Initialize all reference beans, call at Dubbo starting
     *
     * @throws Exception
     */
    public void prepareReferenceBeans() throws Exception;

    /**
     * NOTE: This method should only call after all dubbo config beans and all property resolvers is loaded.
     *
     * @param referenceBean
     * @throws Exception
     */
    private synchronized void initReferenceBean(ReferenceBean referenceBean) throws Exception;
}

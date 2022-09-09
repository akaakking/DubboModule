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
import org.apache.dubbo.common.config.ConfigurationUtils;
import org.apache.dubbo.common.config.Environment;
import org.apache.dubbo.common.config.InmemoryConfiguration;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.ClassUtils;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.FieldUtils;
import org.apache.dubbo.common.utils.MethodUtils;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.context.ConfigManager;
import org.apache.dubbo.config.context.ConfigMode;
import org.apache.dubbo.config.support.Nested;
import org.apache.dubbo.config.support.Parameter;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.apache.dubbo.common.utils.ClassUtils.isSimpleType;
import static org.apache.dubbo.common.utils.ReflectUtils.findMethodByMethodSignature;
import static org.apache.dubbo.config.Constants.PARAMETERS;

/**
 * Utility methods and public methods for parsing configuration
 *
 * @export
 */
public abstract class AbstractConfig implements Serializable {

    public static String getTagName(Class<?> cls);

    public static String getPluralTagName(Class<?> cls);

    public static void appendParameters(Map<String, String> parameters, Object config);

    @SuppressWarnings("unchecked")
    public static void appendParameters(Map<String, String> parameters, Object config, String prefix);

    /**
     * Put attributes of specify 'config' into 'parameters' argument
     *
     * @param parameters
     * @param config
     */
    public static void appendAttributes(Map<String, String> parameters, Object config);

    public static void appendAttributes(Map<String, String> parameters, Object config, String prefix);

    private static void appendParameters0(Map<String, String> parameters, Object config, String prefix, boolean asParameters);

    protected static String extractPropertyName(String setter);

    private static String calculatePropertyToGetter(String name);

    private static String calculatePropertyToSetter(String name);

    private static String calculatePropertyFromGetter(String name);

    private static String calculateAttributeFromGetter(String getter);

    private static void invokeSetParameters(Class c, Object o, Map map);

    private static Map<String, String> invokeGetParameters(Class c, Object o);

    private static boolean isParametersGetter(Method method);

    private static boolean isParametersSetter(Method method);

    private static boolean isNestedGetter(Object obj, Method method);

    private static boolean isNestedSetter(Object obj, Method method);

    /**
     * @param parameters the raw parameters
     * @param prefix     the prefix
     * @return the parameters whose raw key will replace "-" to "."
     * @revised 2.7.8 "private" to be "protected"
     */
    protected static Map<String, String> convert(Map<String, String> parameters, String prefix);

    public ApplicationModel getApplicationModel();

    public ScopeModel getScopeModel();

    public final void setScopeModel(ScopeModel scopeModel);

    protected void checkScopeModel(ScopeModel scopeModel);

    /**
     * Subclass should override this method to initialize its SPI extensions and change referenced config's scope model.
     * <p>
     * For example:
     * <pre>
     * protected void postProcessAfterScopeModelChanged() {
     *   super.postProcessAfterScopeModelChanged();
     *   // re-initialize spi extension
     *   this.protocol = this.getExtensionLoader(Protocol.class).getAdaptiveExtension();
     *   // change referenced config's scope model
     *   if (this.providerConfig != null && this.providerConfig.getScopeModel() != scopeModel) {
     *     this.providerConfig.setScopeModel(scopeModel);
     *   }
     * }
     * </pre>
     *
     * @param oldScopeModel
     * @param newScopeModel
     */
    protected void postProcessAfterScopeModelChanged(ScopeModel oldScopeModel, ScopeModel newScopeModel);

    protected <T> ExtensionLoader<T> getExtensionLoader(Class<T> type);

    @Parameter(excluded = true)
    public String getId();

    public void setId(String id);

    /**
     * Copy attributes from annotation
     *
     * @param annotationClass
     * @param annotation
     */
    protected void appendAnnotation(Class<?> annotationClass, Object annotation);

    /**
     * <p>
     * <b>The new instance of the AbstractConfig subclass should return empty metadata.</b>
     * The purpose is to get the attributes set by the user instead of the default value when the {@link #refresh()} method handles attribute overrides.
     * </p>
     *
     * <p><b>The default value of the field should be set in the {@link #checkDefault()} method</b>,
     * which will be called at the end of {@link #refresh()}, so that it will not affect the behavior of attribute overrides.</p>
     *
     * <p></p>
     * Should be called after Config was fully initialized.
     * <p>
     * Notice! This method should include all properties in the returning map, treat @Parameter differently compared to appendParameters?
     * </p>
     * // FIXME: this method should be completely replaced by appendParameters?
     * // -- Url parameter may use key, but props override only use property name. So replace it with appendAttributes().
     *
     * @see AbstractConfig#checkDefault()
     * @see AbstractConfig#appendParameters(Map, Object, String)
     */
    public Map<String, String> getMetaData();

    public Map<String, String> getMetaData(String prefix);

    private static BeanInfo getBeanInfo(Class cls);

    private static boolean isWritableProperty(BeanInfo beanInfo, String key);

    @Parameter(excluded = true, attribute = false)
    public List<String> getPrefixes();

    public static String getTypePrefix(Class<? extends AbstractConfig> cls);

    public ConfigMode getConfigMode();

    public void overrideWithConfig(AbstractConfig newOne, boolean overrideAll);

    /**
     * Dubbo config property override
     */
    public void refresh();

    private void assignProperties(Object obj, Environment environment, Map<String, String> properties, InmemoryConfiguration configuration);

    private boolean isPropertySet(Method[] methods, String propertyName);

    private Method findGetMethod(Method[] methods, String methodName);

    private void invokeSetParameters(Map<String, String> values, Object obj);

    private boolean isIgnoredAttribute(Class<?> clazz, String propertyName);

    protected void processExtraRefresh(String preferredPrefix, InmemoryConfiguration subPropsConfiguration);

    protected void preProcessRefresh();

    protected void postProcessRefresh();

    /**
     * Check and set default value for some fields.
     * <p>
     * This method will be called at the end of {@link #refresh()}, as a post-initializer.
     * </p>
     * <p>NOTE: </p>
     * <p>
     * To distinguish between user-set property values and default property values,
     * do not initialize default value at field declare statement. <b>If the field has a default value,
     * it should be set in the checkDefault() method</b>, which will be called at the end of {@link #refresh()},
     * so that it will not affect the behavior of attribute overrides.</p>
     *
     * @see AbstractConfig#getMetaData()
     * @see AbstractConfig#appendAttributes(Map, Object)
     */
    protected void checkDefault();

    @Parameter(excluded = true, attribute = false)
    public boolean isRefreshed();

    /**
     * FIXME check @Parameter(required=true) and any conditions that need to match.
     */
    @Parameter(excluded = true, attribute = false)
    public boolean isValid();

    @Parameter(excluded = true, attribute = false)
    public Boolean isDefault();

    public void setDefault(Boolean isDefault);

    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();

    private List<Method> getAttributedMethods();

    /**
     * compute attributed getter methods, subclass can override this method to add/remove attributed methods
     *
     * @return
     */
    protected List<Method> computeAttributedMethods();

    protected ConfigManager getConfigManager();
}

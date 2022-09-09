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

import org.apache.dubbo.common.utils.ArrayUtils;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.alibaba.spring.util.AnnotationUtils.getAttribute;
import static org.springframework.util.ClassUtils.getAllInterfacesForClass;
import static org.springframework.util.StringUtils.hasText;

/**
 * Dubbo Annotation Utilities Class
 *
 * @see org.springframework.core.annotation.AnnotationUtils
 * @since 2.5.11
 */
public class DubboAnnotationUtils {

    @Deprecated
    public static String resolveInterfaceName(Service service, Class<?> defaultInterfaceClass) throws IllegalStateException;

    /**
     * Resolve the service interface name from @Service annotation attributes.
     * <p/>
     * Note: the service interface class maybe not found locally if is a generic service.
     *
     * @param attributes             annotation attributes of {@link Service @Service}
     * @param defaultInterfaceClass the default class of interface
     * @return the interface name if found
     * @throws IllegalStateException if interface name was not found
     */
    public static String resolveInterfaceName(Map<String, Object> attributes, Class<?> defaultInterfaceClass);

    @Deprecated
    public static String resolveInterfaceName(Reference reference, Class<?> defaultInterfaceClass) throws IllegalStateException;

    /**
     * Resolve the parameters of {@link org.apache.dubbo.config.annotation.DubboService}
     * and {@link org.apache.dubbo.config.annotation.DubboReference} from the specified.
     * It iterates elements in order.The former element plays as key or key&value role, it would be
     * spilt if it contains specific string, for instance, ":" and "=". As for later element can't
     * be split in anytime.It will throw IllegalArgumentException If converted array length isn't
     * even number.
     * The convert cases below work in right way,which are best practice.
     * <p>
     * (array->map)
     * ["a","b"] ==> {a=b}
     * [" a "," b "] ==> {a=b}
     * ["a=b"] ==>{a=b}
     * ["a:b"] ==>{a=b}
     * ["a=b","c","d"] ==>{a=b,c=d}
     * ["a","a:b"] ==>{a="a:b"}
     * ["a","a,b"] ==>{a="a,b"}
     * </p>
     *
     * @param parameters
     * @return
     */
    public static Map<String, String> convertParameters(String[] parameters);
}

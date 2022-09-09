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
import org.apache.dubbo.common.utils.UrlUtils;
import org.apache.dubbo.config.nested.AggregationConfig;
import org.apache.dubbo.config.nested.PrometheusConfig;
import org.apache.dubbo.config.support.Nested;
import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.HashMap;
import java.util.Map;

/**
 * MetricsConfig
 */
public class MetricsConfigInterface extends AbstractConfig {

    public String getProtocol();

    public void setProtocol(String protocol);

    public Boolean getEnableJvmMetrics();

    public void setEnableJvmMetrics(Boolean enableJvmMetrics);

    public String getPort();

    public void setPort(String port);

    public void setPrometheus(PrometheusConfig prometheus);

    public AggregationConfigInterface getAggregation();

    public void setAggregation(AggregationConfig aggregation);
}

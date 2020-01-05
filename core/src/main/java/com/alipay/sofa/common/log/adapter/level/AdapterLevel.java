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
package com.alipay.sofa.common.log.adapter.level;

import com.alipay.sofa.common.utils.AssertUtil;

/**
 * AdapterLevel
 * <p>
 * 适配日志级别,通过这个日志级别来适配映射 log4j、log4j2 和 logback 的日志级别,通过统一接口来屏蔽差异
 * <p>
 * <p>
 * Created by yangguanchao on 17/4/28.
 */
public enum AdapterLevel {

    /**
     * An error in the application, possibly recoverable.
     */
    ERROR("error"),

    /**
     * An event that might possible lead to an error.
     */
    WARN("warn"),

    /**
     * An event for informational purposes.
     */
    INFO("info"),

    /**
     * A general debugging event.
     */
    DEBUG("debug"),

    /**
     * A fine-grained debug message, typically capturing the flow through the application.
     */
    TRACE("trace");

    private String logLevelMsg;

    private AdapterLevel(String logLevelMsg) {
        this.logLevelMsg = logLevelMsg;
    }

    public static AdapterLevel getAdapterLevel(String adapterLogLevelMsg) {
        AssertUtil.hasText(adapterLogLevelMsg, "Input Param of AdapterLevel Type can't be blank!");
        for (AdapterLevel adapterLevel : AdapterLevel.values()) {
            if (adapterLevel.getLogLevelMsg().equals(adapterLogLevelMsg)) {
                return adapterLevel;
            }
        }
        throw new IllegalArgumentException(
            "Input Level Message[" + adapterLogLevelMsg
                    + "] can't match any [com.alipay.sofa.common.log.adapter.level.AdapterLevel]");
    }

    public String getLogLevelMsg() {
        return logLevelMsg;
    }

    @Override
    public String toString() {
        return "AdapterLevel{" + "logLevelMsg='" + logLevelMsg + '\'' + '}';
    }
}

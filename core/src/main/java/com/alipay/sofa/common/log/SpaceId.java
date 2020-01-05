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
package com.alipay.sofa.common.log;

import com.alipay.sofa.common.utils.AssertUtil;

import java.util.*;

/**
 * 带有扩展属性的Space唯一Id
 *
 * @author xuanbei
 * @since 2017/07/03
 */
public class SpaceId {

    private final Map<String, String> tags = new HashMap<String, String>();

    private final String              spaceName;

    public SpaceId(String spaceName) {
        AssertUtil.notNull(spaceName);
        this.spaceName = spaceName;
    }

    public SpaceId withTag(String key, String value) {
        tags.put(key, value);
        return this;
    }

    public String getSpaceName() {
        return spaceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SpaceId spaceId = (SpaceId) o;

        if (tags != null ? !tags.equals(spaceId.tags) : spaceId.tags != null)
            return false;
        return spaceName != null ? spaceName.equals(spaceId.spaceName) : spaceId.spaceName == null;

    }

    @Override
    public int hashCode() {
        int result = tags != null ? tags.hashCode() : 0;
        result = 31 * result + (spaceName != null ? spaceName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        if (tags == null || tags.size() == 0) {
            return spaceName;
        }

        StringBuilder sb = new StringBuilder(spaceName);
        sb.append("[");
        Iterator<Map.Entry<String, String>> iterator = tags.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

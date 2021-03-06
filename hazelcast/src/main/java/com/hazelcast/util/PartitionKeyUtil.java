/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.util;

public class PartitionKeyUtil {

    public static String getBaseName(String name){
        if(name == null)return null;
        int indexOf = name.indexOf('@');
        if(indexOf == -1) return name;
        return name.substring(0,indexOf);
    }

    public static Object getPartitionKey(Object key) {
        if (key == null) return null;
        if (!(key instanceof String)) return key;

        String s = (String) key;
        int firstIndexOf = s.indexOf('@');
        if (firstIndexOf > -1) {
            key = s.substring(firstIndexOf + 1);
        }

        return key;
    }

    //we don't want any instances
    private PartitionKeyUtil(){}
}

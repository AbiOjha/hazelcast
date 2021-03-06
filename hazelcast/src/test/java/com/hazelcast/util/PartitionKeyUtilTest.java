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

import org.junit.Test;

import java.util.Date;

import static com.hazelcast.util.PartitionKeyUtil.getBaseName;
import static com.hazelcast.util.PartitionKeyUtil.getPartitionKey;
import static org.junit.Assert.assertEquals;

public class PartitionKeyUtilTest {

    @Test
    public void testGetBaseName() {
        assertEquals("foo", getBaseName("foo"));
        assertEquals("", getBaseName(""));
        assertEquals(null, getBaseName(null));
        assertEquals("foo", getBaseName("foo@bar"));
        assertEquals("foo", getBaseName("foo@"));
        assertEquals("", getBaseName("@bar"));
        assertEquals("foo", getBaseName("foo@bar@nii"));
    }

    @Test
    public void testGetPartitionKey() {
        Date date = new Date();
        assertEquals(date, getPartitionKey(date));
        assertEquals("foo", getPartitionKey("foo"));
        assertEquals("", getPartitionKey(""));
        assertEquals(null, getPartitionKey(null));
        assertEquals("bar", getPartitionKey("foo@bar"));
        assertEquals("", getPartitionKey("foo@"));
        assertEquals("bar", getPartitionKey("@bar"));
        assertEquals("bar@nii", getPartitionKey("foo@bar@nii"));
    }
}

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

package org.apache.shardingsphere.driver.jdbc.core.driver;

import org.apache.shardingsphere.driver.jdbc.exception.syntax.DriverURLProviderNotFoundException;
import org.apache.shardingsphere.infra.util.spi.ShardingSphereServiceLoader;

/**
 * ShardingSphere driver URL manager.
 */
public final class ShardingSphereDriverURLManager {
    
    /**
     * Get config content from url.
     * 
     * @param url the driver url
     * @return the config content
     */
    public static byte[] getContent(final String url) {
        for (ShardingsphereDriverURLProvider each : ShardingSphereServiceLoader.getServiceInstances(ShardingsphereDriverURLProvider.class)) {
            if (each.accept(url)) {
                return each.getContent(url);
            }
        }
        throw new DriverURLProviderNotFoundException(url);
    }
}

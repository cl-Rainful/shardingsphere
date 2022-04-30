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

package org.apache.shardingsphere.data.pipeline.spi.ratelimit;

import org.apache.shardingsphere.data.pipeline.api.job.JobOperationType;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithm;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmPostProcessor;

/**
 * Job rate limit algorithm.
 */
public interface JobRateLimitAlgorithm extends ShardingSphereAlgorithm, ShardingSphereAlgorithmPostProcessor {
    
    /**
     * Intercept.
     *
     * @param type job operation type
     * @param data it's delta that means how much changed if type is INSERT, DELETE, UPDATE, SELECT; it's null if type is SYSTEM_LOAD, CPU_USAGE
     */
    void intercept(JobOperationType type, Number data);
}
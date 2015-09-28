/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sqoop.mapreduce;

import org.apache.avro.Schema;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.junit.Assert;

import java.math.BigDecimal;

/**
 * Helper class for setting up an orc MapReduce job.
 */
public final class ORCJob {
    public static final String MAP_OUTPUT_SCHEMA = "orc.map.output.schema";

    /**
     * The configuration key for a job's output schema.
     */
    public static final String OUTPUT_SCHEMA = "orc.output.schema";

    private ORCJob() {
    }

    public static void setMapOutputSchema(Configuration job, String s) {
        job.set(MAP_OUTPUT_SCHEMA, s.toString());
    }

    /**
     * Return a job's map output key schema.
     */
    public static String getMapOutputSchema(Configuration job) {
        return job.get(MAP_OUTPUT_SCHEMA, job.get(OUTPUT_SCHEMA));
    }

    /**
     * Return a job's output key schema.
     */
    public static String getOutputSchema(Configuration job) {
        return job.get(OUTPUT_SCHEMA);
    }


    /**
     *
     * some special data type is not supported in orc,should covert it to hive type
     * @param obj Object
     * @return
     */
    public static Object convertSpecialRecordType(Object obj) {
        if (obj instanceof java.math.BigDecimal) {
            // not allow Rounding
            return HiveDecimal.create((BigDecimal) obj,false);
        } else {
            return obj;
        }
    }
}

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

import com.cloudera.sqoop.lib.SqoopRecord;
import com.cloudera.sqoop.mapreduce.AutoProgressMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.ql.io.orc.OrcSerde;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.StructTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Writable;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Imports records by transforming them to Avro records in an Avro data file.
 */
public class OrcImportMapper
        extends AutoProgressMapper<LongWritable, SqoopRecord,
        Object, Writable> {
    public static final Log LOG = LogFactory.getLog(OrcImportMapper.class.getName());

    private StructTypeInfo typeInfo;
    private ObjectInspector oip;
    private OrcSerde serde = new OrcSerde();
    private Writable row;
    private Map<String, Integer> indexOFFieldsName;
    private ArrayList<String> fieldNameList;

    @Override
    protected void setup(Context context)
            throws IOException, InterruptedException {
        Configuration conf = context.getConfiguration();
        String orcSchema = ORCJob.getMapOutputSchema(conf);
        LOG.info("orc schema = " + orcSchema);
        typeInfo = (StructTypeInfo) TypeInfoUtils.getTypeInfoFromTypeString(orcSchema);
        oip = TypeInfoUtils.getStandardJavaObjectInspectorFromTypeInfo(typeInfo);
        fieldNameList = typeInfo.getAllStructFieldNames();
    }

    @Override
    protected void cleanup(Context context) throws IOException {
        // do clean
    }

    @Override
    public void map(LongWritable key, SqoopRecord val, Context context)
            throws IOException, InterruptedException {
        List<Object> struct = toGenericRecord(val.getFieldMap());
        row = serde.serialize(struct, oip);
        context.write(null, row);
    }

    public List<Object> toGenericRecord(Map<String, Object> fieldMap) {
        List<Object> struct = new ArrayList<Object>(fieldNameList.size());
        for (String fieldName:fieldNameList) {
            Object obj = fieldMap.get(fieldName);
            obj = ORCJob.convertSpecialRecordType(obj);
            struct.add(obj);
        }
        return struct;
    }
    //HiveDecimal
}

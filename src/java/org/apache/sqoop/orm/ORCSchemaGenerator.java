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

package org.apache.sqoop.orm;

import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.manager.ConnManager;
import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.Schema.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.serde2.typeinfo.StructTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Creates an Avro schema to represent a table from a database.
 */
public class ORCSchemaGenerator {

    public static final Log LOG =
            LogFactory.getLog(ORCSchemaGenerator.class.getName());

    private final SqoopOptions options;
    private final ConnManager connManager;
    private final String tableName;

    public ORCSchemaGenerator(final SqoopOptions opts, final ConnManager connMgr,
                              final String table) {
        this.options = opts;
        this.connManager = connMgr;
        this.tableName = table;
    }

    public String generate() throws IOException {
        ClassWriter classWriter = new ClassWriter(options, connManager,
                tableName, null);
        Map<String, Integer> columnTypes = classWriter.getColumnTypes();
        String[] columnNames = classWriter.getColumnNames(columnTypes);

        List<Field> fields = new ArrayList<Field>();

        // init empty buf
        ArrayList<String> cleanedCols = new ArrayList<String>();
        StringBuilder colTypeBuf = new StringBuilder();
        boolean first = true;
        for (String columnName : columnNames) {
            String cleanedCol = ClassWriter.toJavaIdentifier(columnName);
            int sqlType = columnTypes.get(columnName);
            String orcType = toORCType(sqlType);
            if (!first) {
                colTypeBuf.append(":");
            }
            cleanedCols.add(cleanedCol);
            colTypeBuf.append(orcType);
            first = false;
        }

        ArrayList<TypeInfo> fieldTypes =
                TypeInfoUtils.getTypeInfosFromTypeString(colTypeBuf.toString().toLowerCase());
        StructTypeInfo rootType = new StructTypeInfo();
        rootType.setAllStructFieldNames(cleanedCols);
        rootType.setAllStructFieldTypeInfos(fieldTypes);
        return rootType.toString();
    }

    private String toORCType(int sqlType) {
        return connManager.toHiveORCType(sqlType);
    }

}

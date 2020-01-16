/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.analysys.presto.connector.hbase.utils;

import static com.facebook.presto.spi.type.BigintType.BIGINT;
import static com.facebook.presto.spi.type.BooleanType.BOOLEAN;
import static com.facebook.presto.spi.type.DoubleType.DOUBLE;
import static com.facebook.presto.spi.type.IntegerType.INTEGER;
import static com.facebook.presto.spi.type.TimestampType.TIMESTAMP;
import static com.facebook.presto.spi.type.VarcharType.VARCHAR;

/**
 * Constant
 *
 * @author wupeng
 * @date 2019/01/29
 */
public interface Constant {

    String ARRAY_STRING_SPLITTER = "\001";
    String ROWKEY_SPLITER = "\001";

    String COMMA = ",";
    String ROWKEY_TAIL = "|";
    String SWUNG_DASH = "~";

    /**
     * DecimalType(DECIMAL_DEFAULT_PRECISION, DECIMAL_DEFAULT_SCALE)
     */
    int DECIMAL_DEFAULT_PRECISION = 18;
    int DECIMAL_DEFAULT_SCALE = 3;

    int BATCHGET_SPLIT_RECORD_COUNT = 20;
    int BATCHGET_SPLIT_MAX_COUNT = 30;
    int SYSTEMOUT_INTERVAL = 40;
    int ROWKEY_PREFIX_SPLIT_COUNT = 20;
    int MAX_SPLIT_COUNT = 100;

    String CONNECTOR_NAME = "hbase";
    String DEFAULT_HBASE_NAMESPACE_NAME = "default";
    String TABLE_META_FILE_TAIL = ".json";
    String JSON_ENCODING_UTF8 = "UTF-8";

    enum CONDITION_OPER {
        // bigger
        GT,
        // less
        LT,
        // equal
        EQ,
        // greater than or equal to
        GE,
        // less than or equal to
        LE
    }

    Class VARCHAR_CLASS = VARCHAR.getClass();
    Class INTEGER_CLASS = INTEGER.getClass();
    Class BIGINT_CLASS = BIGINT.getClass();
    Class DOUBLE_CLASS = DOUBLE.getClass();
    Class TIMESTAMP_CLASS = TIMESTAMP.getClass();
    Class BOOLEAN_CLASS = BOOLEAN.getClass();

}

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
package com.analysys.presto.connector.hbase.query;

import static com.facebook.presto.spi.StandardErrorCode.NOT_SUPPORTED;
import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

import javax.inject.Inject;

import com.analysys.presto.connector.hbase.connection.HBaseClientManager;
import com.analysys.presto.connector.hbase.meta.HBaseInsertTableHandle;
import com.facebook.presto.spi.ConnectorInsertTableHandle;
import com.facebook.presto.spi.ConnectorOutputTableHandle;
import com.facebook.presto.spi.ConnectorPageSink;
import com.facebook.presto.spi.ConnectorSession;
import com.facebook.presto.spi.PrestoException;
import com.facebook.presto.spi.connector.ConnectorPageSinkProvider;
import com.facebook.presto.spi.connector.ConnectorTransactionHandle;

/**
 * HBase page sink provider
 *
 * @author wupeng
 * @date 2018/4/25
 */
public class HBasePageSinkProvider implements ConnectorPageSinkProvider {
    private final HBaseClientManager clientManager;

    @Inject
    public HBasePageSinkProvider(HBaseClientManager clientManager) {
        this.clientManager = requireNonNull(clientManager, "clientManager is null");
    }

    /**
     * This interface is used for create table xxx as select * from table_a limit 11;
     * @param transactionHandle transactionHandle
     * @param session session
     * @param outputTableHandle outputTableHandle
     * @return ConnectorPageSink
     */
    @Override
    public ConnectorPageSink createPageSink(ConnectorTransactionHandle transactionHandle, ConnectorSession session,
                                            ConnectorOutputTableHandle outputTableHandle) {
        throw new PrestoException(NOT_SUPPORTED, "This connector does not support creating table.");
    }

    @Override
    public ConnectorPageSink createPageSink(ConnectorTransactionHandle transactionHandle, ConnectorSession session,
                                            ConnectorInsertTableHandle insertTableHandle) {
        requireNonNull(insertTableHandle, "insertTableHandle is null.");
        checkArgument(insertTableHandle instanceof HBaseInsertTableHandle,
                "insertTableHandle is not an instance of HBaseInsertTableHandle.");
        HBaseInsertTableHandle handle = (HBaseInsertTableHandle) insertTableHandle;

        return new HBasePageSink(clientManager, handle);
    }
}

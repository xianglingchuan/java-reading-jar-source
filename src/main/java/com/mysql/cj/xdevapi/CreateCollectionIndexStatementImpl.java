/*
  Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.xdevapi;

import java.util.concurrent.CompletableFuture;

import com.mysql.cj.api.xdevapi.CreateCollectionIndexStatement;
import com.mysql.cj.api.xdevapi.Result;
import com.mysql.cj.x.core.MysqlxSession;
import com.mysql.cj.x.core.StatementExecuteOk;

public class CreateCollectionIndexStatementImpl implements CreateCollectionIndexStatement {
    private MysqlxSession mysqlxSession;
    private String schemaName;
    private String collectionName;
    private CreateIndexParams createIndexParams;

    /* package private */ CreateCollectionIndexStatementImpl(MysqlxSession mysqlxSession, String schema, String collection, String indexName, boolean unique) {
        this.mysqlxSession = mysqlxSession;
        this.schemaName = schema;
        this.collectionName = collection;
        this.createIndexParams = new CreateIndexParams(indexName, unique);
    }

    public CreateCollectionIndexStatement field(String docPath, String type, boolean notNull) {
        this.createIndexParams.addField(docPath, type, notNull);
        return this;
    }

    public Result execute() {
        StatementExecuteOk ok = this.mysqlxSession.createCollectionIndex(this.schemaName, this.collectionName, this.createIndexParams);
        return new UpdateResult(ok, null);
    }

    public CompletableFuture<Result> executeAsync() {
        CompletableFuture<StatementExecuteOk> okF = this.mysqlxSession.asyncCreateCollectionIndex(this.schemaName, this.collectionName, this.createIndexParams);
        return okF.thenApply(ok -> new UpdateResult(ok, null));
    }
}

/**
 * Copyright 2013 freiheit.com technologies gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.freiheit.sqlapi4j.query.statements;

import java.util.List;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.freiheit.sqlapi4j.meta.TableDef;
import com.freiheit.sqlapi4j.query.BooleanExpression;
import com.freiheit.sqlapi4j.query.ColumnAssignment;
import com.freiheit.sqlapi4j.query.FromDef;

/**
 * Data of an insert statement.
 *
 * @author Klas Kalass (klas.kalass@freiheit.com)
 *
 */
public interface InsertStatement {

    /**
     * The result of an insert statement.
     *
     * Will always include the number of rows inserted, and will
     * probably include the generated Ids, if there were any.
     */
    public interface Result<I> {
        int getNofRowsInserted();
        List<I> getInsertedIds() throws UnsupportedOperationException;

    }

    @Nonnull
    TableDef getTable();

    /**
     * The rows to insert.
     *
     * Each item in the list corresponds to one row in the insert statement.
     * @return the rows to insert.
     */
    @Nonnull
    List<ColumnAssignment<?>[]> getRows();

    @CheckForNull
    BooleanExpression getWhere();

    @CheckForNull
    FromDef[] getFromDefs();

}

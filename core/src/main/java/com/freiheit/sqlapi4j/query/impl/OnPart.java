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
package com.freiheit.sqlapi4j.query.impl;

import javax.annotation.Nonnull;

import com.freiheit.sqlapi4j.meta.AbstractColumnDef;
import com.freiheit.sqlapi4j.query.BooleanExpression;
import com.freiheit.sqlapi4j.query.FromDef;

/**
 * Interface for the on part of a join.
 *
 * @author Christoph Mewes (christoph.mewes@freiheit.com)
 */
public interface OnPart {

    /**
     * Adds the columns and returns the completed FromDef.
     */
    @Nonnull
    public FromDef on(@Nonnull AbstractColumnDef<?> left,
                       @Nonnull AbstractColumnDef<?> right);

    /**
     * Adds the columns and additional expression and returns the completed FromDef.
     */
    @Nonnull
    public FromDef on(@Nonnull AbstractColumnDef<?> left,
                       @Nonnull AbstractColumnDef<?> right,
                       @Nonnull BooleanExpression additionalExpr);
}

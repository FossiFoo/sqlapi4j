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
package com.freiheit.sqlapi4j.dao.meta;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import com.freiheit.sqlapi4j.domain.type.Id;
import com.freiheit.sqlapi4j.meta.DbType;

/**
 * A converter from {@link Id} to {@link Long}.
 *
 * @param <T> der Typ der Id
 * @author Andreas Baldeau (andreas.baldeau@freiheit.com) (initial creation)
 */
@ParametersAreNonnullByDefault
public class IdConverter<T extends Id> extends AbstractColumnConverter<T, Long> {

    public IdConverter() {
        super(SqlTypes.BIGINT);
    }

    @Override
    public Long toDb(@Nullable final T id, final DbType<T> dbType) {
        return id == null ? null : id.asLong();
    }

    @Override
    public T fromDb(@Nullable final Long val, final DbType<T> dbType) {
        return val == null ? null : Id.valueOf(((IdDbType<T>) dbType).getTypeClass(), val.longValue());
    }

}

/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.hibernate6.jpa.repository.kotlin

import io.micronaut.data.annotation.QueryHint
import io.micronaut.data.hibernate6.jpa.repository.intercept.FlushInterceptor
import io.micronaut.data.hibernate6.jpa.repository.intercept.LoadInterceptor
import io.micronaut.data.intercept.annotation.DataMethod
import io.micronaut.data.model.Sort
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import io.micronaut.data.repository.kotlin.CoroutinePageableCrudRepository
import kotlinx.coroutines.flow.Flow
import java.io.Serializable
import javax.validation.Valid

/**
 * Simple composed repository interface that includes {@link CrudRepository} and {@link PageableRepository}.
 *
 * @param <E> The entity type
 * @param <ID> The ID type
 * @since 1.0.0
 * @author graemerocher
 */
interface CoroutineJpaRepository<E, ID> : CoroutineCrudRepository<E, ID>, CoroutinePageableCrudRepository<E, ID> {

    override fun <S : E> saveAll(entities: @Valid Iterable<S>): Flow<S>

    override fun findAll(): Flow<E>

    override fun findAll(sort: Sort): Flow<E>

    /**
     * Save and perform a flush() of any pending operations.
     * @param entity The entity
     * @param <S> The entity generic type
     * @return The entity, possibly mutated
     */
    @QueryHint(name = "jakarta.persistence.FlushModeType", value = "AUTO")
    suspend fun <S : E> saveAndFlush(entity: @Valid S): S

    /**
     * Adds a flush method.
     */
    @DataMethod(interceptor = FlushInterceptor::class)
    suspend fun flush()

    /**
     * Adds a load method.
     * @param id the entity ID
     * @param <S> the entity type
     * @return An uninitialized proxy
     */
    @DataMethod(interceptor = LoadInterceptor::class)
    suspend fun <S : E> load(id: Serializable): S
}

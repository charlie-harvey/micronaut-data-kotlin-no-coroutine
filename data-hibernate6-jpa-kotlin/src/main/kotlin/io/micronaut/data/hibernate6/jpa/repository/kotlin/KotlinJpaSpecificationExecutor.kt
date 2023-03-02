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

import io.micronaut.data.hibernate6.jpa.repository.criteria.Specification
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort

/**
 * Interface to allow execution of {@link Specification}s based on the JPA criteria API.
 *
 * Note: Forked from 'org.springframework.data.jpa.repository.JpaSpecificationExecutor'.
 *
 * @param <T> The entity type
 * @author Oliver Gierke
 * @author Christoph Strobl
 * @since 3.1
 */
interface KotlinJpaSpecificationExecutor<T> {

    /**
     * Returns a single entity matching the given [Specification] or [T?] if none found.
     *
     * @param spec can be null.
     * @return never null.
     */
    fun findOne(spec: Specification<T>?): T?

    /**
     * Returns all entities matching the given [Specification].
     *
     * @param spec can be null.
     * @return never null.
     */
    fun findAll(spec: Specification<T>?): List<T>

    /**
     * Returns a [Page] of entities matching the given [Specification].
     *
     * @param spec can be null.
     * @param pageable must not be null.
     * @return never null.
     */
    fun findAll(spec: Specification<T>?, pageable: Pageable): Page<T>

    /**
     * Returns all entities matching the given [Specification] and [Sort].
     *
     * @param spec can be null.
     * @param sort must not be null.
     * @return never null.
     */
    fun findAll(spec: Specification<T>?, sort: Sort): List<T>

    /**
     * Returns the number of instances that the given [Specification] will return.
     *
     * @param spec the [Specification] to count instances for. Can be null.
     * @return the number of instances.
     */
    fun count(spec: Specification<T>?): Long
}

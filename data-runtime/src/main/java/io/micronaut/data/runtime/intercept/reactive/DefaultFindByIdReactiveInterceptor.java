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
package io.micronaut.data.runtime.intercept.reactive;

import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.intercept.RepositoryMethodKey;
import io.micronaut.data.intercept.reactive.FindByIdReactiveInterceptor;
import io.micronaut.data.operations.RepositoryOperations;
import org.reactivestreams.Publisher;

import java.io.Serializable;

/**
 * Default implementation of {@link FindByIdReactiveInterceptor}.
 * @author graemerocher
 * @since 1.0.0
 */
public class DefaultFindByIdReactiveInterceptor extends AbstractPublisherInterceptor
        implements FindByIdReactiveInterceptor<Object, Object> {
    /**
     * Default constructor.
     *
     * @param operations The operations
     */
    protected DefaultFindByIdReactiveInterceptor(@NonNull RepositoryOperations operations) {
        super(operations);
    }

    @Override
    public Publisher<?> interceptPublisher(RepositoryMethodKey methodKey, MethodInvocationContext<Object, Object> context) {
        Class<?> rootEntity = getRequiredRootEntity(context);
        Object id = context.getParameterValues()[0];
        if (!(id instanceof Serializable)) {
            throw new IllegalArgumentException("Entity IDs must be serializable!");
        }
        return reactiveOperations.findOne((Class<Object>) rootEntity, (Serializable) id);
    }
}

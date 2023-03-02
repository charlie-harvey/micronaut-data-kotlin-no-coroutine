package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.document.tck.entities.DomainEvents
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface DomainEventsRepository : KotlinCrudRepository<DomainEvents, String>

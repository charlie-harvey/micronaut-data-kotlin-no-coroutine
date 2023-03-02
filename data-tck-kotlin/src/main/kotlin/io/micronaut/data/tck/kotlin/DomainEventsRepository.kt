package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.DomainEvents
import java.util.*

interface DomainEventsRepository : KotlinCrudRepository<DomainEvents, UUID>

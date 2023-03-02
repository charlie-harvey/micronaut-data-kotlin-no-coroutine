package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import io.micronaut.data.tck.entities.DomainEvents
import java.util.*

interface DomainEventsCoroutineRepository : CoroutineCrudRepository<DomainEvents, UUID>

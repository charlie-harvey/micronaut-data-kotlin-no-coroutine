package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.document.tck.entities.Zone
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface ZoneRepository : KotlinCrudRepository<Zone, Long>

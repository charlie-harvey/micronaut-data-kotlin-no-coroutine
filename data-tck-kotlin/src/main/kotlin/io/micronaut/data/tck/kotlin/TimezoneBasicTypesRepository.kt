package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.TimezoneBasicTypes
import io.micronaut.data.tck.entities.TimezoneBasicTypesProjection

interface TimezoneBasicTypesRepository : KotlinCrudRepository<TimezoneBasicTypes, Long> {

    fun queryById(id: Long): TimezoneBasicTypesProjection?

    fun findAllById(id: Long): Collection<TimezoneBasicTypesProjection>
}

package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.CountryRegion

interface RegionRepository : KotlinCrudRepository<CountryRegion, Long> {

    @Join(value = "cities", alias = "c")
    fun findByCitiesName(name: String): CountryRegion?
}

package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.City

interface CityRepository : KotlinCrudRepository<City, Long> {

    fun countByCountryRegionCountryName(name: String): Int

    @Join(value = "countryRegion", alias = "cr")
    fun findByCountryRegionCountryName(name: String): List<City>

    @Join(value = "countryRegion", alias = "cr")
    @Join(value = "countryRegion.country", alias = "c")
    fun getByCountryRegionCountryName(name: String): List<City>
}

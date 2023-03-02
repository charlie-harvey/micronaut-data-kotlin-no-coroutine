package io.micronaut.data.tck.kotlin

import io.micronaut.data.tck.entities.CountryRegionCity

interface CountryRegionCityRepository {

    fun save(countryRegionCity: CountryRegionCity): CountryRegionCity
}

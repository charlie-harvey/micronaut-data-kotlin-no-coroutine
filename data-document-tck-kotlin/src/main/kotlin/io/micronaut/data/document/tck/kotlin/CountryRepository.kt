package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.document.tck.entities.County
import io.micronaut.data.document.tck.entities.CountyPk
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface CountryRepository : KotlinCrudRepository<County, CountyPk>

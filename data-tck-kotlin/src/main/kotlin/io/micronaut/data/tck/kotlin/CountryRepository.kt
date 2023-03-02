package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Country
import java.util.*

interface CountryRepository : KotlinCrudRepository<Country, UUID>

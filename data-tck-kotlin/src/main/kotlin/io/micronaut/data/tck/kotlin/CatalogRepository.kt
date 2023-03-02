package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.jdbc.entities.Catalog
import java.util.*

interface CatalogRepository : KotlinCrudRepository<Catalog, UUID>

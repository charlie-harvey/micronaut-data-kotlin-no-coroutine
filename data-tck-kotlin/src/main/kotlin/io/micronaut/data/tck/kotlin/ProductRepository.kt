package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Product
import java.math.BigDecimal

interface ProductRepository : KotlinCrudRepository<Product, Long> {

    fun update(@Id id: Long, @Parameter("price") price: BigDecimal)
}

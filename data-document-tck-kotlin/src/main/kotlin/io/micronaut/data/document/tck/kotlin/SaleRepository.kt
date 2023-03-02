package io.micronaut.data.document.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.document.tck.entities.Quantity
import io.micronaut.data.document.tck.entities.Sale
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface SaleRepository : KotlinCrudRepository<Sale, String> {

    fun updateQuantity(@Parameter("id") @Id id: String, @Parameter("quantity") quantity: Quantity): Long
}

package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.document.tck.entities.Address
import io.micronaut.data.document.tck.entities.Restaurant
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface RestaurantRepository : KotlinCrudRepository<Restaurant, String> {

    fun findByAddress(address: Address): Restaurant?
}

package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Address
import io.micronaut.data.tck.entities.Restaurant

interface RestaurantRepository : KotlinCrudRepository<Restaurant, Long> {

    fun findByAddress(address: Address): Restaurant?

    fun getMaxAddressStreetByName(name: String): String?

    fun getMinAddressStreetByName(name: String): String?
}

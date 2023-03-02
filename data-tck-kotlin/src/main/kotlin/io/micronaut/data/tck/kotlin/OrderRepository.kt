package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Order

interface OrderRepository : KotlinCrudRepository<Order,Long>

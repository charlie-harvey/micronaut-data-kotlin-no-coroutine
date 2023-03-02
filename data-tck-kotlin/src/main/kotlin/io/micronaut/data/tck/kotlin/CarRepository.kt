package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Car

interface CarRepository : KotlinCrudRepository<Car, Long> {

    fun update(@Id id: Long, @Parameter("name") name: String?)

    @Join(value = "parts", type = Join.Type.LEFT)
    fun getById(id: Long): Car?
}

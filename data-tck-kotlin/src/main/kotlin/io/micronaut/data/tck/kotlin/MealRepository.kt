package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Meal

interface MealRepository : KotlinCrudRepository<Meal, Long> {

    @Join("foods")
    fun searchById(uuid: Long): Meal?

    fun findByIdForUpdate(id: Long): Meal?

    @Join("foods")
    fun searchByIdForUpdate(id: Long): Meal?

    fun findAllForUpdate(): Iterable<Meal>

    fun findAllByCurrentBloodGlucoseLessThan(currentBloodGlucose: Int): Iterable<Meal>

    fun findAllByCurrentBloodGlucoseLessThanForUpdate(currentBloodGlucose: Int): Iterable<Meal>

    fun findByFoodsPortionGramsGreaterThan(portionGrams: Int): Iterable<Meal>

    fun findByFoodsPortionGramsGreaterThanForUpdate(portionGrams: Int): Iterable<Meal>
}

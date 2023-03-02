package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.document.tck.entities.Citizen
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface CitizenRepository : KotlinCrudRepository<Citizen, String> {

    @Join(value = "settlements.id.county")
    @Join(value = "settlements.zone")
    @Join(value = "settlements.settlementType")
    override fun findById(id: String): Citizen?

    fun queryById(id: String): Citizen?
}

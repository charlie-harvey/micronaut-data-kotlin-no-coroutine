package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.document.tck.entities.Settlement
import io.micronaut.data.document.tck.entities.SettlementPk
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface SettlementRepository : KotlinCrudRepository<Settlement, SettlementPk> {

    @Join(value = "settlementType")
    @Join(value = "zone")
    override fun findById(id: SettlementPk): Settlement?

    @Join(value = "settlementType")
    @Join(value = "zone")
    @Join(value = "id.county")
    fun queryById(settlementPk: SettlementPk): Settlement?

    @Join(value = "settlementType")
    @Join(value = "zone")
    @Join(value = "id.county")
    fun findAll(pageable: Pageable): List<Settlement>
}

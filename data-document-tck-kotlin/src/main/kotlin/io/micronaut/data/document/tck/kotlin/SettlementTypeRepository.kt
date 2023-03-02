package io.micronaut.data.document.tck.kotlin

import io.micronaut.data.document.tck.entities.SettlementType
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface SettlementTypeRepository : KotlinCrudRepository<SettlementType, Long>

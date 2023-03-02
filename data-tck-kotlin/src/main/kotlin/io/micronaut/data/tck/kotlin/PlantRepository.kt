package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Plant

interface PlantRepository : GenericRepository<Plant, Long> {

    fun save(plant: Plant): Plant

    fun findById(id: Long): Plant?
}

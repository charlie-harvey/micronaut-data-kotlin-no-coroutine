package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Face

interface FaceRepository : KotlinCrudRepository<Face, Long> {

    @Join("nose")
    fun queryById(id: Long): Face?
}

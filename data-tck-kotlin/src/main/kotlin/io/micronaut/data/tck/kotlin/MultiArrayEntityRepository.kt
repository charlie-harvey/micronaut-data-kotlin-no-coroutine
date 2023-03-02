package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.MultiArrayEntity

interface MultiArrayEntityRepository : KotlinCrudRepository<MultiArrayEntity, Long> {

    fun update(@Id id: Long, @Parameter("stringMultiArray") stringMultiArray: Array<Array<String>>)
}

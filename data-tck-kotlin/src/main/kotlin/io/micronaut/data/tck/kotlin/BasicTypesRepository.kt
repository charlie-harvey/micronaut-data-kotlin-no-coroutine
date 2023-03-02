package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Query
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.BasicTypes
import io.micronaut.data.tck.entities.BasicTypesProjection
import java.util.*

interface BasicTypesRepository : KotlinCrudRepository<BasicTypes, Long> {

    fun update(@Id id: Long, @Parameter("byteArray") byteArray: ByteArray)

    fun findByByteArray(@Parameter("byteArray") byteArray: ByteArray): BasicTypes?

    fun queryById(id: Long): BasicTypesProjection?

    fun findAllById(id: Long): Collection<BasicTypesProjection>

    @Query("select null")
    fun somethingThatMightSometimesReturnNull(): String?
}

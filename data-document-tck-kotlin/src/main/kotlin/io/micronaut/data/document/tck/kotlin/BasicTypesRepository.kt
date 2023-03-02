package io.micronaut.data.document.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.document.tck.entities.BasicTypes
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface BasicTypesRepository : KotlinCrudRepository<BasicTypes, String> {

    fun update(@Id id: String, @Parameter("byteArray") byteArray: ByteArray)

    fun findByByteArray(@Parameter("byteArray") byteArray: ByteArray): BasicTypes?
}

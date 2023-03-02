package io.micronaut.data.document.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Version
import io.micronaut.data.document.tck.entities.Student
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

interface StudentRepository : KotlinCrudRepository<Student, String> {

    fun updateByIdAndVersion(id: String, version: Long, name: String)

    fun updateById(@Id id: String, @Parameter("name") name: String)

    fun deleteByIdAndVersionAndName(@Id id: String, @Version version: Long, name: String)

    fun deleteByIdAndVersion(@Id id: String, @Version version: Long)
}

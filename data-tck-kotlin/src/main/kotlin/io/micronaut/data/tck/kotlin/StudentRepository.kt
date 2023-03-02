package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.Version
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Student
import java.util.*

interface StudentRepository : KotlinCrudRepository<Student, Long> {

    fun updateByIdAndVersion(id: Long, version: Long, name: String)

    fun updateById(@Id id: Long, @Parameter("name") name: String)

    fun deleteByIdAndVersionAndName(@Id id: Long, @Version version: Long, name: String)

    fun deleteByIdAndVersion(@Id id: Long, @Version version: Long)

    @Join(value = "books", type = Join.Type.FETCH)
    fun findByName(name: String): Student?
}

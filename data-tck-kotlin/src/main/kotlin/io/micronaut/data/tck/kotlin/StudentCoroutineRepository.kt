package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Version
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import io.micronaut.data.tck.entities.Student
import io.reactivex.Completable

interface StudentCoroutineRepository : CoroutineCrudRepository<Student, Long> {

    suspend fun updateByIdAndVersion(@Id id: Long, @Version version: Long, @Parameter("name") name: String): Int

    fun updateById(@Id id: Long, @Parameter("name") name: String): Int

    fun deleteByIdAndVersionAndName(@Id id: Long, @Version version: Long, name: String): Int

    fun deleteByIdAndVersion(@Id id: Long, @Version version: Long): Int
}

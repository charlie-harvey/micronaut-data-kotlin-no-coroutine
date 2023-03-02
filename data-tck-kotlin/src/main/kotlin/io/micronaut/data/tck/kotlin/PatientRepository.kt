package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Query
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Patient
import io.micronaut.data.tck.entities.PatientDto
import java.util.*

interface PatientRepository : KotlinCrudRepository<Patient, Long> {

    @Query("select * from patient where name = :name")
    fun findByNameWithQuery(name: String): PatientDto?

    @Query("select * from patient where name = :name")
    fun findAllByNameWithQuery(name: String): List<PatientDto>
}

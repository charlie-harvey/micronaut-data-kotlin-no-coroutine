package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.repository.kotlin.KotlinPageableRepository
import io.micronaut.data.tck.entities.Company
import java.time.Instant

interface CompanyRepository : KotlinPageableRepository<Company, Long> {

    fun update(@Id id: Long, @Parameter("name") name: String)

    fun findMaxLastUpdated(): Instant?

    fun findMinLastUpdated(): Instant?

    fun findByLastUpdatedGreaterThan(date: Instant): Company?

    fun findByLastUpdatedLessThan(date: Instant): Company?
}

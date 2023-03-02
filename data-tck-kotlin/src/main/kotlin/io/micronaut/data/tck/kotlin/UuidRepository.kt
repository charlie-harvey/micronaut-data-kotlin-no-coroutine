package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.core.annotation.Nullable
import io.micronaut.data.annotation.Query
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.UuidEntity
import java.util.*

interface UuidRepository : KotlinCrudRepository<UuidEntity, UUID> {

    fun findUuidByName(name: String): UUID?

    /**
     * This method semantically makes no sense because it'll always produce NULL
     * without correctly wrapping nullable value like this:
     * WHERE :nullableValue IS NULL AND nullable_value IS NULL
     *       OR
     *       :nullableValue IS NOT NULL AND nullable_value = :nullableValue
     */
    @Query(value = "select * from uuid_entity where :param is null", nativeQuery = true)
    fun findByNullableValue(@Parameter("param") @Nullable param: UUID?): Collection<UuidEntity>
}

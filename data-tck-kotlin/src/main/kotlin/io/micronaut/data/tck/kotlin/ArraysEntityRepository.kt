package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.ArraysDto
import io.micronaut.data.tck.entities.ArraysEntity

interface ArraysEntityRepository : KotlinCrudRepository<ArraysEntity, Long> {

    fun update(
        @Id id: Long,
        @Parameter("stringArray") stringArray: Array<String>,
        @Parameter("stringArrayCollection") stringArrayCollection: Collection<String>,
        @Parameter("shortArray") shortArray: Array<Short>,
        @Parameter("shortPrimitiveArray") shortPrimitiveArray: ShortArray,
        @Parameter("shortArrayCollection") shortArrayCollection: Collection<Short>,
        @Parameter("integerArray") integerArray: Array<Int>?,
        @Parameter("integerPrimitiveArray") integerPrimitiveArray: IntArray?,
        @Parameter("integerArrayCollection") integerArrayCollection: Collection<Int>?
    )

    fun queryBySomeId(someId: Long): ArraysDto?
}

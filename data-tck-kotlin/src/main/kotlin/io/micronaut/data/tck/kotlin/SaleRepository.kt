package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Sale
import io.micronaut.data.tck.entities.SaleDTO
import java.util.*

interface SaleRepository : KotlinCrudRepository<Sale, Long> {

    fun getById(id: Long): SaleDTO?

    @Join(value = "items", type = Join.Type.LEFT_FETCH)
    override fun findById(id: Long): Sale?

    fun updateData(
        @Id id: Long,
        @Parameter("data") data: Map<String, String>,
        @Parameter("dataList") dataList: List<String>
    )
}

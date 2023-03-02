package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Query
import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Product
import io.micronaut.data.tck.entities.ProductDto
import java.util.*

interface ProductDtoRepository : GenericRepository<Product, Long> {

    @Query(
        "select p.id, p.name, p.price, p.loooooooooooooooooooooooooooooooooooooooooooooooooooooooong_name AS long_name, " +
                "p.date_created, p.last_updated from product p where p.name = :name order by p.name"
    )
    fun findByNameWithQuery(name: String): ProductDto?

    fun findByNameLikeOrderByName(name: String): List<ProductDto>
}

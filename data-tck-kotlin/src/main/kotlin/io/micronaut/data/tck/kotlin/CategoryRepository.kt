package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Category

interface CategoryRepository : KotlinCrudRepository<Category, Long> {

    @Join(value = "productList", type = Join.Type.LEFT_FETCH)
    override fun findAll(): List<Category>

    @Join(value = "productList", type = Join.Type.LEFT_FETCH)
    fun findAllOrderById(): List<Category>

    @Join(value = "productList", type = Join.Type.LEFT_FETCH)
    fun findAllOrderByName(): List<Category>

    @Join(value = "productList", type = Join.Type.LEFT_FETCH)
    fun findAllOrderByPositionAndName(): List<Category>

    @Join(value = "productList", type = Join.Type.LEFT_FETCH)
    fun findAll(pageable: Pageable): Page<Category>
}

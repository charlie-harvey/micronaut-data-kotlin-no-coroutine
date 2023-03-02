package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Shelf

interface ShelfRepository : GenericRepository<Shelf, Long> {

    fun save(shelfName: String): Shelf

    fun save(shelf: Shelf): Shelf

    @Join(value = "books", type = Join.Type.LEFT_FETCH, alias = "b_")
    @Join(value = "books.pages", type = Join.Type.LEFT_FETCH, alias = "p_")
    fun findById(id: Long): Shelf?
}

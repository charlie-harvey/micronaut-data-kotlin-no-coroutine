package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Book
import io.micronaut.data.tck.entities.Shelf
import io.micronaut.data.tck.entities.ShelfBook

interface ShelfBookRepository : GenericRepository<ShelfBook, Any> {

    fun save(shelf: Shelf, book: Book): ShelfBook
}

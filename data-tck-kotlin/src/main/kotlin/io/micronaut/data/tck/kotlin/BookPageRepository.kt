package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Book
import io.micronaut.data.tck.entities.BookPage
import io.micronaut.data.tck.entities.Page

interface BookPageRepository : GenericRepository<BookPage, Any> {

    fun save(book: Book, page: Page): BookPage
}

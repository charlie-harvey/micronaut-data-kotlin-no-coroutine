package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Query
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Book
import io.micronaut.data.tck.entities.BookDto
import java.util.*
import java.util.stream.Stream

interface BookDtoRepository : GenericRepository<Book, Long> {

    @Query("select * from book b where b.title = :title")
    fun findByTitleWithQuery(title: String): BookDto?

    fun findByTitleLike(title: String): List<BookDto>

    fun findOneByTitle(title: String): BookDto?

    fun searchByTitleLike(title: String, pageable: Pageable): Page<BookDto>

    fun queryAll(pageable: Pageable): Page<BookDto>

    fun findStream(title: String): Stream<BookDto>
}

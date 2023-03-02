package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.entities.Book
import io.micronaut.data.tck.entities.Chapter
import io.micronaut.data.tck.entities.Page

interface PageRepository : GenericRepository<Page, Long> {

    fun save(num: Long): Page

    @Join(value = "book.chapters", type = Join.Type.LEFT_FETCH)
    fun findBookById(id: Long): Book?

    // No explicit joins
    fun findBookChaptersById(id: Long): List<Chapter>

    // Join on book so chapters.book will be populated
    @Join(value = "book.chapters.book", type = Join.Type.FETCH)
    fun findBookChaptersByIdAndNum(id: Long, num: Long): List<Chapter>
}

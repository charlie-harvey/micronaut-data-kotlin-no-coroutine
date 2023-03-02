package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.core.annotation.Nullable
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Author
import java.util.*
import java.util.stream.Stream

interface AuthorRepository : KotlinCrudRepository<Author, Long> {

    @Join(value = "books", type = Join.Type.LEFT_FETCH)
    fun queryByName(name: String): Author?

    @Join(value = "books", alias = "b", type = Join.Type.LEFT_FETCH)
    @Join(value = "books.pages", alias = "bp", type = Join.Type.LEFT_FETCH)
    override fun findById(id: Long): Author?

    fun findByName(name: String): Author?

    fun findByBooksTitle(title: String): Author?

    fun countByNameContains(text: String): Long

    fun findByNameStartsWith(name: String): Author?

    fun findByNameStartsWithIgnoreCase(name: String): Author?

    fun findByNameContains(name: String): List<Author>

    fun findByNameContainsIgnoreCase(name: String): List<Author>

    fun queryByNameContains(name: String): Stream<Author>

    fun findByNameEndsWithIgnoreCase(name: String): Author?

    fun findByNameEndsWith(name: String): Author?

    fun findByNameIgnoreCase(name: String): Author?

    @Join("books")
    fun searchByName(name: String): Author?

    @Nullable
    @Join("books")
    fun retrieveByName(name: String): Author?

    // Various list all authors with different join types:

    // Various list all authors with different join types:
    @Join("books")
    fun listAll(): List<Author>

    @Join(value = "books", type = Join.Type.LEFT_FETCH)
    fun findByIdIsNotNull(): List<Author>

    @Join(value = "books", type = Join.Type.LEFT_FETCH)
    fun queryByIdIsNotNull(): Stream<Author>

    @Join(value = "books", type = Join.Type.RIGHT_FETCH)
    fun findByNameIsNotNull(): List<Author>

    fun updateNickname(@Id id: Long, @Parameter("nickName") nickName: String?)

    @Join(value = "books", type = Join.Type.LEFT_FETCH)
    fun findAll(pageable: Pageable): Page<Author>
}

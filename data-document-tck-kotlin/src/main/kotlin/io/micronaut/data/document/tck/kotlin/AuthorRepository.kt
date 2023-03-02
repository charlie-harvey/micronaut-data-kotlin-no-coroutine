package io.micronaut.data.document.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.core.annotation.Nullable
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.document.tck.entities.Author
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import java.util.*
import java.util.stream.Stream

interface AuthorRepository : KotlinCrudRepository<Author, String> {

    fun findByName(name: String): Author?

    fun updateNickname(@Id id: String, @Parameter("nickName") @Nullable nickName: String?)

    @Join(value = "books")
    @Join(value = "books.pages")
    override fun findById(id: String): Author?

    @Join("books")
    fun queryByName(name: String): Author?

    fun findByBooksTitle(title: String): Author?

    @Join("books")
    fun searchByName(name: String): Author?

    fun queryByNameRegex(name: String): Stream<Author>
}

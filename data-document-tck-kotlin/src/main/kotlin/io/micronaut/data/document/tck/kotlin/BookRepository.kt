package io.micronaut.data.document.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.TypeDef
import io.micronaut.data.document.tck.entities.Author
import io.micronaut.data.document.tck.entities.AuthorBooksDto
import io.micronaut.data.document.tck.entities.Book
import io.micronaut.data.model.DataType
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.kotlin.KotlinPageableRepository
import java.util.stream.Stream

abstract class BookRepository(
    private val authorRepository: AuthorRepository
) : KotlinPageableRepository<Book, String> {

    @Join("author")
    abstract fun findByTotalPagesGreaterThan(totalPages: Int, pageable: Pageable): Page<Book>

    @Join("author.books")
    abstract override fun findAll(): List<Book>

    @Join("author")
    abstract fun findByTitle(title: String): Book?

    abstract fun updateAuthor(@Parameter("id") @Id id: String, @Parameter("author") author: Author): Long

    abstract fun deleteByIdAndAuthorId(id: String, authorId: String): Int

    abstract fun findTop3ByAuthorNameOrderByTitle(name: String): Stream<Book>

    abstract fun queryTop3ByAuthorNameOrderByTitle(name: String): List<Book>

    abstract fun findByAuthorIsNull(): List<Book>
    abstract fun findByAuthorIsNotNull(): List<Book>
    abstract fun countByTitleIsEmpty(): Int
    abstract fun countByTitleIsNotEmpty(): Int

    abstract fun deleteByTitleIsEmptyOrTitleIsNull()

    abstract fun findTop3OrderByTitle(): List<Book>

    abstract fun findByAuthorName(name: String?): List<Book>

    abstract fun listByTitleIn(arg0: Collection<String>?): List<Book>

    abstract fun listByTitleIn(@TypeDef(type = DataType.STRING) arg0: Array<String>?): List<Book>

    abstract fun listByTitleIn(@TypeDef(type = DataType.STRING_ARRAY) arg0: List<String>?): List<Book>

    abstract fun findByTitleIn(@TypeDef(type = DataType.STRING_ARRAY) arg0: Array<String>?): List<Book>

    open fun saveAuthorBooks(authorBooksDtos: List<AuthorBooksDto>) {
        val authors: MutableList<Author> = ArrayList()
        for (dto in authorBooksDtos) {
            val author: Author = newAuthor(dto.authorName)
            authors.add(author)
            for (book in dto.books) {
                newBook(author, book.title, book.totalPages)
            }
        }
        authorRepository.saveAll(authors)
    }

    protected open fun newAuthor(name: String): Author {
        val author = Author()
        author.name = name
        return author
    }

    protected open fun newBook(author: Author, title: String?, pages: Int): Book {
        val book = Book()
        author.books.add(book)
        book.author = author
        book.title = title
        book.totalPages = pages
        return book
    }
}

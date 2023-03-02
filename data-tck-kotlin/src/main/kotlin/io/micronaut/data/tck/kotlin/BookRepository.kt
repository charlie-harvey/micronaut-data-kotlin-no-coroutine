package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.*
import io.micronaut.data.model.DataType
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification
import io.micronaut.data.repository.jpa.kotlin.KotlinJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.KotlinPageableRepository
import io.micronaut.data.tck.entities.Author
import io.micronaut.data.tck.entities.AuthorBooksDto
import io.micronaut.data.tck.entities.Book
import io.micronaut.data.tck.entities.Genre
import io.micronaut.data.tck.repositories.AuthorRepository
import java.util.*
import java.util.stream.Stream

abstract class BookRepository(
    private val authorRepository: AuthorRepository
) : KotlinPageableRepository<Book, Long>, KotlinJpaSpecificationExecutor<Book> {

    @Join(value = "author", alias = "auth")
    abstract fun queryByTitle(title: String): Book?

    @Query(
        value = "SELECT book_.* FROM book book_ LEFT JOIN author book_author_ ON book_.author_id = book_author_.id",
        countQuery = "SELECT count(*) FROM book book_ "
    )
    abstract fun listPageableCustomQuery(pageable: Pageable): Page<Book>

    @Join("author")
    abstract override fun findAll(pageable: Pageable): Page<Book>

    @Join(value = "author", type = Join.Type.LEFT_FETCH)
    abstract fun findByTotalPagesGreaterThan(totalPages: Int, pageable: Pageable): Page<Book>

    abstract fun findAllByTitleStartingWith(text: String): List<Book>

    abstract fun findByAuthorIsNull(): List<Book>
    abstract fun findByAuthorIsNotNull(): List<Book>
    abstract fun countByTitleIsEmpty(): Int
    abstract fun countByTitleIsNotEmpty(): Int

    abstract fun findByAuthorName(name: String): List<Book>

    abstract fun findTop3OrderByTitle(): List<Book>

    abstract fun findTop3ByAuthorNameOrderByTitle(name: String): Stream<Book>

    abstract fun queryTop3ByAuthorNameOrderByTitle(name: String): List<Book>

    abstract fun deleteByTitleIsEmptyOrTitleIsNull()

    @Join("author")
    abstract fun findByTitle(title: String): Book?

    abstract fun findAuthorById(@Id id: Long): Author?

    @Query(value = "select * from book b where b.title like :arg0 limit 5", nativeQuery = true)
    abstract fun listNativeBooks(arg0: String): List<Book>

    @Query(value = "select * from book b where b.title in (:arg0)", nativeQuery = true)
    abstract fun listNativeBooksWithTitleInCollection(arg0: Collection<String>?): List<Book>

    @Query(value = "select * from book b where b.title IN (:arg0)", nativeQuery = true)
    abstract fun listNativeBooksWithTitleInArray(@Expandable @TypeDef(type = DataType.STRING) arg0: Array<String>?): List<Book>

    @Query(value = "select * from book b where b.title = any (:arg0)", nativeQuery = true)
    abstract fun listNativeBooksWithTitleAnyCollection(arg0: Collection<String>?): List<Book>

    @Query(value = "select * from book b where b.title = ANY (:arg0)", nativeQuery = true)
    abstract fun listNativeBooksWithTitleAnyArray(@TypeDef(type = DataType.STRING) arg0: Array<String>?): List<Book>

    @Query(
        value = "select * from book where (CASE WHEN exists ( select (:arg0) ) THEN title = ANY (:arg0) ELSE true END)",
        nativeQuery = true
    )
    abstract fun listNativeBooksNullableListAsStringArray(@TypeDef(type = DataType.STRING_ARRAY) arg0: List<String>?): List<Book>

    @Query(
        value = "select * from book where (CASE WHEN exists ( select (:arg0) ) THEN title = ANY (:arg0) ELSE true END)",
        nativeQuery = true
    )
    abstract fun listNativeBooksNullableArrayAsStringArray(@TypeDef(type = DataType.STRING_ARRAY) arg0: Array<String>?): List<Book>

    @Query("UPDATE book SET author_id = :author WHERE id = :id")
    abstract fun updateAuthorCustom(@Parameter("id") id: Long, @Parameter("author") author: Author): Long

    abstract fun updateAuthor(@Parameter("id") @Id id: Long, @Parameter("author") author: Author): Long

    abstract fun updateByIdInList(id: List<Long>, title: String)

    open fun saveAuthorBooks(authorBooksDtos: List<AuthorBooksDto>) {
        val authors = mutableListOf<Author>()
        for (dto in authorBooksDtos) {
            val author = newAuthor(dto.authorName)
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

    protected open fun newBook(author: Author, title: String, pages: Int): Book {
        val book = Book()
        author.books.add(book)
        book.author = author
        book.title = title
        book.totalPages = pages
        return book
    }

    abstract fun deleteByIdAndAuthorId(id: Long, authorId: Long): Int

    abstract fun save(title: String, totalPages: Int, author: Author): Book

    abstract fun deleteByAuthor(author: Author): Int

    @Join(value = "genre", type = Join.Type.LEFT_FETCH)
    abstract fun findAllByGenre(genre: Genre): List<Book>

    @Join(value = "genre", type = Join.Type.LEFT_FETCH)
    abstract override fun findOne(spec: PredicateSpecification<Book>?): Book?

    @Join(value = "genre", type = Join.Type.LEFT_FETCH)
    abstract override fun findAll(spec: PredicateSpecification<Book>?): List<Book>

    abstract fun findAllByCriteria(spec: PredicateSpecification<Book>?): List<Book>

    abstract fun findByTitleOrAuthorAndId(title: String, author: Author, id: Long): Book?

    abstract fun findAllByChaptersTitle(chapterTitle: String): List<Book>

    @Join(value = "chapters", type = Join.Type.LEFT_FETCH)
    abstract fun findAllByChaptersTitleAndTitle(chapterTitle: String, title: String): List<Book>
}

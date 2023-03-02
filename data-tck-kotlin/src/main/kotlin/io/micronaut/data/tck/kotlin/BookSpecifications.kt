package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.model.jpa.criteria.PersistentEntityFrom
import io.micronaut.data.model.jpa.criteria.PersistentEntityJoin
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification
import io.micronaut.data.tck.entities.Book
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Root

class BookSpecifications private constructor() {

    companion object {
        const val TITLE_FIELD = "title"
    }

    fun titleEquals(title: String): PredicateSpecification<Book> =
        PredicateSpecification { root: Root<Book>, criteriaBuilder: CriteriaBuilder ->
            criteriaBuilder.equal(root.get<Book>(TITLE_FIELD), title)
        }

    fun titleEqualsWithJoin(title: String): PredicateSpecification<Book> =
        PredicateSpecification { root: Root<Book>, criteriaBuilder: CriteriaBuilder ->
            (root as PersistentEntityFrom<*, *>).join<Any, Any>(
                "genre",
                Join.Type.LEFT_FETCH
            )
            criteriaBuilder.equal(root.get<Book>(TITLE_FIELD), title)
        }

    fun hasChapter(chapterTitle: String): PredicateSpecification<Book> =
        PredicateSpecification { root: Root<Book>, criteriaBuilder: CriteriaBuilder ->
            val join: PersistentEntityJoin<*, *> =
                (root as PersistentEntityFrom<*, *>).join<Any, Any>("chapters")
            criteriaBuilder.equal(join.get<Book>(TITLE_FIELD), chapterTitle
            )
        }

}

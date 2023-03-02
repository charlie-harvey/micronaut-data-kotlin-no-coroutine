package io.micronaut.data.document.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.document.tck.entities.Person
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Slice
import io.micronaut.data.model.Sort
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification
import io.micronaut.data.repository.jpa.kotlin.KotlinJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.repository.kotlin.KotlinPageableRepository
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Root
import java.time.LocalDate
import java.util.*

interface PersonRepository : KotlinCrudRepository<Person, String>, KotlinPageableRepository<Person, String>,
    KotlinJpaSpecificationExecutor<Person> {

    fun listTop10(sort: Sort): List<Person>

    operator fun get(id: String): Person?

    fun count(name: String): Int

    fun save(@Parameter("name") name: String, @Parameter("age") age: Int): Person

    fun list(pageable: Pageable): List<Person>

    fun updateAll(people: List<Person>): Long

    fun updatePeople(people: List<Person>): List<Person>

    fun findByName(name: String): Person?

    fun updatePerson(@Id id: String?, @Parameter("name") name: String?)

    fun updateByName(name: String, age: Int): Long

    fun findByNameRegex(name: String): List<Person>

    fun findByNameRegex(name: String, pageable: Pageable): List<Person>

    fun getByNameRegex(name: String, pageable: Pageable): Page<Person>

    fun findAllByNameRegex(name: String, pageable: Pageable): Page<Person>

    fun queryByNameRegex(name: String, pageable: Pageable): Slice<Person>

    fun deleteByNameRegex(name: String): Long

    fun updatePersonCount(@Id id: String, @Parameter("name") name: String): Long

    fun countByAgeGreaterThan(wrapper: Int): Int

    fun countByAgeLessThan(wrapper: Int): Int

    fun findAgeByName(name: String): Int

    fun findAllByNameRegex(name: String): List<Person>

    fun findMaxAgeByNameRegex(name: String): Int

    fun findMinAgeByNameRegex(name: String): Int

    fun getSumAgeByNameRegex(name: String): Int

    fun getAvgAgeByNameRegex(name: String): Long

    fun findMaxDateOfBirthByNameRegex(name: String): LocalDate?

    fun findMinDateOfBirthByNameRegex(name: String): LocalDate?

    fun findByDateOfBirthGreaterThan(localDate: LocalDate): List<Person>

    fun findByDateOfBirthGreaterThanEquals(localDate: LocalDate): List<Person>

    fun findByDateOfBirthLessThan(localDate: LocalDate): List<Person>

    fun findByDateOfBirthLessThanEquals(localDate: LocalDate): List<Person>

    fun readAgeByNameRegex(name: String): List<Int>

    fun findByNameRegexOrderByAge(name: String): List<Person>

    fun findByNameRegexOrderByAgeDesc(name: String): List<Person>

    fun findByIdIn(ids: List<String>): List<Person>

    fun findByIdNotIn(ids: List<String>): List<Person>

    fun findByNameIn(names: List<String>): List<Person>

    fun findByNameEqualIgnoreCase(name: String): Person?

    fun findByNameNotEqualIgnoreCase(name: String): List<Person>

    fun findByNameStartsWith(name: String): List<Person>

    fun findByNameStartsWithIgnoreCase(name: String): List<Person>

    fun findByNameEndsWith(name: String): List<Person>

    fun findByNameEndsWithIgnoreCase(name: String): List<Person>

    fun findByNameContains(name: String): List<Person>

    fun findByNameContainsIgnoreCase(name: String): List<Person>

    object Specifications {
        fun nameEquals(name: String?): PredicateSpecification<Person> {
            return PredicateSpecification { root: Root<Person>, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.equal(root.get<Any>("name"), name)
            }
        }

        fun dateOfBirthEquals(localDate: LocalDate?): PredicateSpecification<Person> {
            return PredicateSpecification { root: Root<Person>, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.equal(root.get<Any>("dateOfBirth"), localDate)
            }
        }

        fun nameEqualsCaseInsensitive(name: String): PredicateSpecification<Person> {
            return PredicateSpecification { root: Root<Person>, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.equal(criteriaBuilder.lower(root.get("name")), name.lowercase(Locale.getDefault()))
            }
        }
    }
}

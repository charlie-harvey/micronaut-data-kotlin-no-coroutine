package io.micronaut.data.tck.kotlin

import io.micronaut.context.annotation.Parameter
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Query
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.jpa.kotlin.CoroutineJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.CoroutinePageableCrudRepository
import io.micronaut.data.tck.entities.Person
import io.micronaut.data.tck.entities.PersonDto
import kotlinx.coroutines.flow.Flow

interface PersonCoroutineRepository : CoroutinePageableCrudRepository<Person, Long>, CoroutineJpaSpecificationExecutor<Person> {

    suspend fun save(name: String, age: Int): Person

    suspend fun getById(id: Long): Person?

    suspend fun updatePerson(@Id id: Long, @Parameter("name") name: String): Int

    fun list(pageable: Pageable): Flow<Person>

    suspend fun count(name: String): Long

    suspend fun findByName(name: String): Person?

    suspend fun getByName(name: String): PersonDto?

    fun queryByName(name: String): Flow<PersonDto>

    suspend fun deleteByNameLike(name: String): Int

    fun findByNameLike(name: String): Flow<Person>

    suspend fun findByNameLike(name: String, pageable: Pageable): Page<Person>

    @Query(
        value = "select * from person person_ where person_.name like :n",
        countQuery = "select count(*) from person person_ where person_.name like :n"
    )
    suspend fun findPeople(n: String, pageable: Pageable): Page<Person>

    @Query("SELECT MAX(id) FROM person WHERE id = -1")
    suspend fun getMaxId(): Long

    fun updatePeople(people: List<Person>): Flow<Person>

    @Query("UPDATE person SET name = :newName WHERE (name = :oldName)")
    suspend fun updateNamesCustom(newName: String, oldName: String): Int

    @Query("INSERT INTO person(name, age, enabled) VALUES (:name, :age, TRUE)")
    suspend fun saveCustom(people: List<Person>): Int

    @Query("INSERT INTO person(name, age, enabled) VALUES (:name, :age, TRUE)")
    suspend fun saveCustomSingle(people: Person): Int

    suspend fun remove(id: Long): Int

    suspend fun deleteOneReturnRowsDeleted(people: Person): Int

    suspend fun deleteManyReturnRowsDeleted(people: List<Person>): Int

    @Query("DELETE FROM person WHERE name = :name")
    suspend fun deleteCustom(people: List<Person>): Int

    @Query("DELETE FROM person WHERE name = :name")
    suspend fun deleteCustomSingle(person: Person): Int

    @Query("DELETE FROM person WHERE name = :xyz")
    suspend fun deleteCustomSingleNoEntity(xyz: String): Int
}

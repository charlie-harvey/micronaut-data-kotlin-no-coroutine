
package example

import io.micronaut.data.annotation.Query
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.kotlin.KotlinCrudRepository

@JdbcRepository(dialect = Dialect.H2)
interface UserRepository : KotlinCrudRepository<User, Long> { // <1>

    @Query("UPDATE user SET enabled = false WHERE id = :id") // <2>
    fun softDeleteById(id: Long)

    @Query("SELECT * FROM user WHERE enabled = false") // <3>
    fun findDisabled(): List<User>
}

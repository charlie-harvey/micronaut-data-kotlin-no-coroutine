package example

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.*
import javax.transaction.Transactional

@JdbcRepository(dialect = Dialect.H2)
interface ParentSuspendRepository : CoroutineCrudRepository<Parent, Int> {

    @Join(value = "children", type = Join.Type.FETCH)
    override suspend fun findById(id: Int): Parent?

    suspend fun queryById(id: Int): Parent?

}

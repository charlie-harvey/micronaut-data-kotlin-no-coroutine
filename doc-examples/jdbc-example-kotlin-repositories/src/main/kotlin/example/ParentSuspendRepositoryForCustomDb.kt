package example

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.*
import javax.transaction.Transactional

@JdbcRepository(dataSource = "custom", dialect = Dialect.H2)
interface ParentSuspendRepositoryForCustomDb : CoroutineCrudRepository<Parent, Int> {

    @Join(value = "children", type = Join.Type.FETCH)
    override suspend fun findById(id: Int): Parent?

    @Transactional(Transactional.TxType.MANDATORY)
    suspend fun queryById(id: Int): Parent?

}

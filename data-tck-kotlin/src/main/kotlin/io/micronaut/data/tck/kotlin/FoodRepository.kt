package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification
import io.micronaut.data.repository.jpa.kotlin.KotlinJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.entities.Food
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Root
import java.util.*

interface FoodRepository : KotlinCrudRepository<Food, UUID>, KotlinJpaSpecificationExecutor<Food> {

    @Join("meal")
    override fun findById(id: UUID): Food?

    @Join(value = "alternativeMeal", type = Join.Type.LEFT_FETCH)
    fun searchById(id: UUID): Food?

    @Join("meal")
    fun findByMealMidForUpdate(mid: Long): Food?

    fun findAllByKeyOrderByLongName(key: String): List<Food>

    object Specifications {
        fun keyEquals(key: String): PredicateSpecification<Food> =
            PredicateSpecification { root: Root<Food>, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.equal(root.get<Food>("key"), key)
            }
    }
}

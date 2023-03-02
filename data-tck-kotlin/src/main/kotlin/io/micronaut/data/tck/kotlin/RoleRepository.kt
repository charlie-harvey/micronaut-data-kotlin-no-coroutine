package io.micronaut.data.tck.kotlin

import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.jdbc.entities.Role

interface RoleRepository : KotlinCrudRepository<Role, Long>

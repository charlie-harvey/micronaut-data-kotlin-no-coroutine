package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Join
import io.micronaut.data.repository.GenericRepository
import io.micronaut.data.tck.jdbc.entities.Role
import io.micronaut.data.tck.jdbc.entities.User
import io.micronaut.data.tck.jdbc.entities.UserRole
import io.micronaut.data.tck.jdbc.entities.UserRoleId
import javax.validation.Valid

interface UserRoleRepository : GenericRepository<UserRole, UserRoleId> {

    fun save(entity: @Valid UserRole): UserRole

    fun save(user: User, role: Role): UserRole {
        return save(UserRole(UserRoleId(user, role)))
    }

    fun deleteById(id: UserRoleId)

    fun delete(user: User, role: Role) {
        deleteById(UserRoleId(user, role))
    }

    fun count(): Int

    @Join("role")
    fun findRoleByUser(user: User): Iterable<Role>

    fun deleteAll()
}

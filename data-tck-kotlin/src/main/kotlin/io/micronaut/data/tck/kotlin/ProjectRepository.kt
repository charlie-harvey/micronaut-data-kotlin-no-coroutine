package io.micronaut.data.tck.kotlin

import io.micronaut.data.annotation.Id
import io.micronaut.data.repository.kotlin.KotlinCrudRepository
import io.micronaut.data.tck.jdbc.entities.Project
import io.micronaut.data.tck.jdbc.entities.ProjectId

interface ProjectRepository : KotlinCrudRepository<Project, ProjectId> {

    fun update(@Id projectId: ProjectId, name: String)
}

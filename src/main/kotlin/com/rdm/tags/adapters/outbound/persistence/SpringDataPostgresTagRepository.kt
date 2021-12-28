package com.rdm.tags.adapters.outbound.persistence

import com.rdm.tags.adapters.outbound.persistence.entities.TagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SpringDataPostgresTagRepository: JpaRepository<TagEntity, UUID> {
}
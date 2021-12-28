package com.rdm.tags.adapters.outbound.persistence

import com.rdm.tags.adapters.outbound.persistence.entities.TagEntity
import com.rdm.tags.application.domain.PageInfo
import com.rdm.tags.application.domain.Tag
import com.rdm.tags.application.ports.TagRepositoryPort
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.*
import kotlin.streams.toList


@Component
@Primary
class PostgresTagRepository(val tagRepository: SpringDataPostgresTagRepository, @Autowired
val modelMapper: ModelMapper) : TagRepositoryPort {

    override fun findAll(pageInfo: PageInfo): List<Tag> {
        val pageable: Pageable = PageRequest.of(pageInfo.pageNumber, pageInfo.pageSize)
        val stream = tagRepository.findAll(pageable).get()
        return stream.map { convertToTag(it) }.toList()
    }

    override fun findById(tagId: UUID): Optional<Tag> {
        val tagEntity = tagRepository.findById(tagId)
        return if (tagEntity.isPresent()) {
            Optional.of(convertToTag(tagEntity.get()))
        } else {
            Optional.empty()
        }
    }

    override fun save(tag: Tag): Tag {
        val tagEntity = modelMapper.map(tag, TagEntity::class.java)
        tagRepository.save(tagEntity)
        return tag
    }

    fun convertToTag(entity: TagEntity): Tag {
        return Tag(tagId = entity.tagId,
                name = entity.name,
                quantity = entity.quantity,
                zplLabel = entity.zplLabel,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt)
    }
}
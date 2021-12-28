package com.rdm.tags.application.services

import com.rdm.tags.application.domain.PageInfo
import com.rdm.tags.application.domain.Tag
import com.rdm.tags.application.ports.TagRepositoryPort
import com.rdm.tags.application.ports.TagServicePort
import java.util.*

class TagServiceImpl(private val tagRepositoryPort: TagRepositoryPort) : TagServicePort {

    override fun findAll(pageInfo: PageInfo) = tagRepositoryPort.findAll(pageInfo)

    override fun findById(tagId: UUID) = tagRepositoryPort.findById(tagId)

    override fun save(tag: Tag) = tagRepositoryPort.save(tag)

}
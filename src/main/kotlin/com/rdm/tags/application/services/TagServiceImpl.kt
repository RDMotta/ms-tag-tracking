package com.rdm.tags.application.services

import com.rdm.tags.adapters.PageInfo
import com.rdm.tags.adapters.Tag
import com.rdm.tags.application.ports.TagRepositoryPort
import com.rdm.tags.application.ports.TagServicePort
import java.util.*

class TagServiceImpl(val tagRepositoryPort: TagRepositoryPort): TagServicePort {


    override fun findAll(pageInfo: PageInfo) = tagRepositoryPort.findAll(pageInfo)

    override fun findById(uuid: UUID) = tagRepositoryPort.findById(uuid)

    override fun save(tag: Tag) {
        TODO("Not yet implemented")
    }
}
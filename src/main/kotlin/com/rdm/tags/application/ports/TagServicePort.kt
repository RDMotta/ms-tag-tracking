package com.rdm.tags.application.ports

import com.rdm.tags.adapters.PageInfo
import com.rdm.tags.adapters.Tag
import java.util.*

interface TagServicePort {
    fun findAll(pageInfo: PageInfo): List<Tag>
    fun findById(uuid: UUID): Optional<Tag>
    fun save(tag: Tag)
}
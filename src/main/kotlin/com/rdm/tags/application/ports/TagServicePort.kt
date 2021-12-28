package com.rdm.tags.application.ports

import com.rdm.tags.application.domain.PageInfo
import com.rdm.tags.application.domain.Tag
import java.util.*

interface TagServicePort {
    fun findAll(pageInfo: PageInfo): List<Tag>
    fun findById(tagId: UUID): Optional<Tag>
    fun save(tag: Tag): Tag
}
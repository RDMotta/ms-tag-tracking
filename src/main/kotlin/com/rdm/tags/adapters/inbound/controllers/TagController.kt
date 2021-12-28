package com.rdm.tags.adapters.inbound.controllers

import com.rdm.tags.adapters.dtos.TagDto
import com.rdm.tags.application.domain.PageInfo
import com.rdm.tags.application.domain.Tag
import com.rdm.tags.application.ports.TagServicePort
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class TagController(@Autowired
                    var tagServicePort: TagServicePort) {

    @PostMapping("/tags")
    fun saveTag(@RequestBody @Valid tagDto: TagDto): ResponseEntity<Tag> {
        val tag = Tag(name = tagDto.name, quantity = tagDto.quantity, zplLabel = tagDto.zplLabel)

        return ResponseEntity<Tag>(tagServicePort.save(tag), HttpStatus.CREATED)
    }

    @GetMapping("/tags")
    fun getAllTags(@PageableDefault(page = 0, size = 5, sort = ["tagId"], direction = Sort.Direction.DESC) pageable: Pageable): ResponseEntity<Page<Tag>> {
        val pageInfo = PageInfo(pageable.pageNumber, pageable.pageSize)
        BeanUtils.copyProperties(pageable, pageInfo)
        val tagList = tagServicePort.findAll(pageInfo)
        return ResponseEntity<Page<Tag>>(PageImpl<Tag>(tagList, pageable, tagList.size.toLong()), HttpStatus.OK)
    }

    @GetMapping("/tags/{tagId}")
    fun getOneTag(@PathVariable(value = "tagId") tagId: UUID): ResponseEntity<Any> {
        val tagModelOptional = tagServicePort.findById(tagId)
        return if (!tagModelOptional.isPresent()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tag not found.")
        } else {
            ResponseEntity.status(HttpStatus.OK).body(tagModelOptional.get())
        }
    }
}
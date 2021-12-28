package com.rdm.tags.application.domain

import java.io.Serializable
import java.time.LocalDateTime
import java.util.*


class Tag(val tagId: UUID? = UUID.randomUUID(),
          val name: String? = null,
          val quantity: Int? = null,
          val zplLabel: String? = null,
          val createdAt: LocalDateTime = LocalDateTime.now(),
          val updatedAt: LocalDateTime = LocalDateTime.now()) : Serializable {

}
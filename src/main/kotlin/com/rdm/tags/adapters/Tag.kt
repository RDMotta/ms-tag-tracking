package com.rdm.tags.adapters

import java.time.LocalDateTime
import java.util.*


class Tag(val uuid: UUID,
          val name: String?,
          val quantity: Int = 1,
          val zplLabel: String?,
          val createdAt: LocalDateTime = LocalDateTime.now(),
          val updatedAt: LocalDateTime = LocalDateTime.now())
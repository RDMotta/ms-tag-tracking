package com.rdm.tags.adapters.outbound.persistence.entities

import lombok.Data
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Data
@Entity
@Table(name = "tb_tag")
class TagEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var tagId: UUID,
        @Column
        var name: String? = null,
        @Column
        var quantity: Int? = null,
        @Column(columnDefinition = "TEXT")
        var zplLabel: String? = null,
        @Column
        var createdAt: LocalDateTime = LocalDateTime.now(),
        @Column
        var updatedAt: LocalDateTime = LocalDateTime.now()
) : Serializable {}
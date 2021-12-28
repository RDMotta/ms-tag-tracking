package com.rdm.tags.adapters.dtos

import lombok.Data
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

@Data
data class TagDto(
        @NotBlank
        val name: String? = null,
        @NotBlank
        val quantity: Int? = null,
        @NotBlank
        val zplLabel: String? = null,
        @NotBlank
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @NotBlank
        val updatedAt: LocalDateTime = LocalDateTime.now()) {
}
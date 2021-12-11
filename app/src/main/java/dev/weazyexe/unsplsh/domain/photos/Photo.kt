package dev.weazyexe.unsplsh.domain.photos

import java.time.LocalDate

/**
 * Photo data
 */
data class Photo(
    val id: String,
    val createdAt: LocalDate?,
    val updatedAt: LocalDate?,
    val width: Int,
    val height: Int,
    val color: String,
    val likes: Int,
    val description: String,
    val urls: Urls
)
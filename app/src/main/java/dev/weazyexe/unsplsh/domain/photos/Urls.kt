package dev.weazyexe.unsplsh.domain.photos

/**
 * URLs of a photo with different sizes
 */
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)
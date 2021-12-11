package dev.weazyexe.unsplsh.data.network.photos.dto

import com.google.gson.annotations.SerializedName
import dev.weazyexe.unsplsh.data.base.Transformable
import dev.weazyexe.unsplsh.domain.photos.Urls

/**
 * Urls data transfer object
 */
data class UrlsDto(
    @SerializedName("raw") val raw: String,
    @SerializedName("full") val full: String,
    @SerializedName("regular") val regular: String,
    @SerializedName("small") val small: String,
    @SerializedName("thumb") val thumb: String
): Transformable<Urls> {

    override fun transform(): Urls = Urls(raw, full, regular, small, thumb)
}
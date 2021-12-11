package dev.weazyexe.unsplsh.data.network.photos.dto

import com.google.gson.annotations.SerializedName
import dev.weazyexe.unsplsh.data.base.Transformable
import dev.weazyexe.unsplsh.domain.photos.Photo
import dev.weazyexe.unsplsh.utils.extensions.toDate
import java.util.*

/**
 * Photo data transfer object
 */
data class PhotoDto(
    @SerializedName("id") val id: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("color") val color: String,
    @SerializedName("likes") val likes: Int,
    @SerializedName("description") val description: String,
    @SerializedName("urls") val urls: UrlsDto
) : Transformable<Photo> {

    override fun transform(): Photo = Photo(
        id = id,
        createdAt = createdAt.toDate(),
        updatedAt = updatedAt.toDate(),
        width = width,
        height = height,
        color = color,
        likes = likes,
        description = description,
        urls = urls.transform()
    )
}
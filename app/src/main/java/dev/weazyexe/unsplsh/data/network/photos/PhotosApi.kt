package dev.weazyexe.unsplsh.data.network.photos

import dev.weazyexe.unsplsh.data.network.photos.dto.PhotoDto
import retrofit2.http.GET

/**
 * Photos service API
 */
interface PhotosApi {

    @GET(PhotosUrls.PHOTOS)
    suspend fun getPhotos(): List<PhotoDto>
}
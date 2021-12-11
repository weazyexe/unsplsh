package dev.weazyexe.unsplsh.data.network.photos

import dev.weazyexe.unsplsh.data.base.transform
import dev.weazyexe.unsplsh.domain.photos.Photo
import javax.inject.Inject

/**
 * Source of photos data
 */
class PhotosRepository @Inject constructor(
    private val photosApi: PhotosApi
) {

    suspend fun getPhotos(): List<Photo> = photosApi.getPhotos().transform()
}
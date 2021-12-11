package dev.weazyexe.unsplsh.data.network.photos

import dev.weazyexe.unsplsh.data.base.transform
import dev.weazyexe.unsplsh.domain.photos.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Source of photos data
 */
class PhotosRepository @Inject constructor(
    private val photosApi: PhotosApi
) {

    fun getPhotos(): Flow<List<Photo>> = flow {
        emit(photosApi.getPhotos().transform())
    }
}
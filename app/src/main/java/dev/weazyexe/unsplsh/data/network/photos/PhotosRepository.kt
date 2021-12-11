package dev.weazyexe.unsplsh.data.network.photos

import dev.weazyexe.unsplsh.data.base.transform
import dev.weazyexe.unsplsh.data.network.BaseNetworkConstants.BASE_URL
import dev.weazyexe.unsplsh.domain.photos.Photo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Source of photos data
 */
class PhotosRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val photosApi = retrofit.create(PhotosApi::class.java)

    suspend fun getPhotos(): List<Photo> = photosApi.getPhotos().transform()
}
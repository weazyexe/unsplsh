package dev.weazyexe.unsplsh.data.network.photos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.weazyexe.unsplsh.data.network.photos.PhotosApi
import retrofit2.Retrofit

/**
 * Photos data layer module
 */
@Module
@InstallIn(ActivityComponent::class)
class PhotosModule {

    @Provides
    fun providePhotosApi(retrofit: Retrofit): PhotosApi = retrofit.create(PhotosApi::class.java)
}
package dev.weazyexe.unsplsh.ui.screen.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.weazyexe.unsplsh.data.network.photos.PhotosRepository
import dev.weazyexe.unsplsh.ui.base.BaseViewModel
import dev.weazyexe.unsplsh.ui.base.LoadState
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

/**
 * [MainScreen]'s view model
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val photosRepository: PhotosRepository
) : BaseViewModel<MainState, MainEffect>() {

    override val initialState = MainState()

    init {
        getPhotos()
    }

    fun getPhotos() = viewModelScope.launch {
        state.copy(photos = LoadState.loading()).emit()
        try {
            val photos = photosRepository.getPhotos()
            state.copy(photos = LoadState.data(photos)).emit()
        } catch (e: Exception) {
            state.copy(photos = LoadState.error(e)).emit()
        }
    }
}
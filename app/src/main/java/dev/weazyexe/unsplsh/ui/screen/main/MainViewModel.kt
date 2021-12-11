package dev.weazyexe.unsplsh.ui.screen.main

import androidx.lifecycle.viewModelScope
import dev.weazyexe.unsplsh.data.network.photos.PhotosRepository
import dev.weazyexe.unsplsh.ui.base.BaseViewModel
import dev.weazyexe.unsplsh.ui.base.LoadState
import kotlinx.coroutines.launch

/**
 * [MainScreen]'s view model
 */
class MainViewModel : BaseViewModel<MainState, MainEffect>() {

    private val photosRepository = PhotosRepository()

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
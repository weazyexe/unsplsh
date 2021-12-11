package dev.weazyexe.unsplsh.ui.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

/**
 * Main screen with photos feed
 */
@Composable
@ExperimentalCoilApi
fun MainScreen() {
    val viewModel = viewModel<MainViewModel>()
    val state = viewModel.uiState.collectAsState().value

    val photos = state.photos
    if (photos.isLoading) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(photos.data.orEmpty()) {
                Photo(url = it.urls.full)
            }
        }
    }
}

@Composable
@ExperimentalCoilApi
fun Photo(url: String) {
    Image(
        painter = rememberImagePainter(data = url),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}
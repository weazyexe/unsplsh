package dev.weazyexe.unsplsh.ui.screen.main

import dev.weazyexe.unsplsh.domain.photos.Photo
import dev.weazyexe.unsplsh.ui.base.BaseState
import dev.weazyexe.unsplsh.ui.base.LoadState

/**
 * [MainScreen]'s state
 */
data class MainState(
    val photos: LoadState<List<Photo>> = LoadState()
) : BaseState
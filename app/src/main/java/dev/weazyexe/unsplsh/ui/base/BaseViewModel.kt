package dev.weazyexe.unsplsh.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Base view model with state
 */
abstract class BaseViewModel<S : BaseState, E : BaseEffect> : ViewModel() {

    private val _state by lazy { MutableStateFlow(initialState) }
    protected val uiState: StateFlow<S>
        get() = _state.asStateFlow()
    protected val state: S
        get() = _state.value

    private val _effects = Channel<E>(Channel.BUFFERED)
    val effects: Flow<E>
        get() = _effects.receiveAsFlow()

    abstract val initialState: S

    fun emit(effect: E) {
        effect.emit()
    }

    protected fun E.emit() = viewModelScope.launch {
        _effects.send(this@emit)
    }

    protected suspend fun S.emit() {
        _state.emit(this)
    }
}
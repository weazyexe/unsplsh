package dev.weazyexe.unsplsh.ui.base

import java.io.Serializable
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * Base load state
 *
 * @property data data to load
 * @property error [Exception], what can be thrown during loading
 * @property isLoading loading state
 * @property isSwipeRefresh is loading state emitted by swipe refresh
 */
data class LoadState<T>(
    val data: T? = null,
    val error: Exception? = null,
    val isLoading: Boolean = false,
    val isSwipeRefresh: Boolean = false
) : Serializable {

    companion object {

        fun <T> loading(
            isSwipeRefresh: Boolean = false,
            oldData: T? = null
        ): LoadState<T> =
            LoadState(
                data = oldData,
                error = null,
                isLoading = true,
                isSwipeRefresh = isSwipeRefresh
            )

        fun <T> error(
            e: Exception,
            oldData: T? = null
        ): LoadState<T> =
            LoadState(
                data = oldData,
                error = e,
                isLoading = false,
                isSwipeRefresh = false
            )

        fun <T> data(data: T): LoadState<T> =
            LoadState(
                data = data,
                error = null,
                isLoading = false,
                isSwipeRefresh = false
            )
    }

    fun isNetworkError(): Boolean = error is ConnectException || error is UnknownHostException
}
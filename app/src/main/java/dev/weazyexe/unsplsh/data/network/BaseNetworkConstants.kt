package dev.weazyexe.unsplsh.data.network

import dev.weazyexe.unsplsh.BuildConfig

/**
 * Base network constants (headers, URLs etc.)
 */
object BaseNetworkConstants {

    const val BASE_URL = "https://api.unsplash.com"
    const val API_KEY = BuildConfig.UNSPLASH_API_KEY

    const val AUTHORIZATION_HEADER = "Authorization"
    const val AUTHORIZATION_VALUE = "Client-ID $API_KEY"

    const val ACCEPT_VERSION_HEADER = "Accept-Version"
    const val ACCEPT_VERSION_VALUE = "v1"
}
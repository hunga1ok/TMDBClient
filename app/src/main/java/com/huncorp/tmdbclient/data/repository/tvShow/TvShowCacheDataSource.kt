package com.huncorp.tmdbclient.data.repository.tvShow

import com.huncorp.tmdbclient.data.model.tvShow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}
package com.huncorp.tmdbclient.data.repository.tvShow

import com.huncorp.tmdbclient.data.model.tvShow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromLocal(): List<TvShow>
    suspend fun saveTvShowsToLocal(tvShows: List<TvShow>)
    suspend fun clearAll()
}
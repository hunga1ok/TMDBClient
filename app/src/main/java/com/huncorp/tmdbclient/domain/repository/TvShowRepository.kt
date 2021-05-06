package com.huncorp.tmdbclient.domain.repository

import com.huncorp.tmdbclient.data.model.tvShow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}
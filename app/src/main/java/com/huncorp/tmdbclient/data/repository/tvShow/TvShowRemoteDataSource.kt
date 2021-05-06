package com.huncorp.tmdbclient.data.repository.tvShow

import com.huncorp.tmdbclient.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}
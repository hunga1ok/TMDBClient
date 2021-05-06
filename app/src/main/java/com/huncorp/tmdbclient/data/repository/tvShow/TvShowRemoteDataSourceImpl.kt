package com.huncorp.tmdbclient.data.repository.tvShow

import com.huncorp.tmdbclient.data.api.TMDBService
import com.huncorp.tmdbclient.data.model.tvShow.TvShowList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShow(apiKey)
}
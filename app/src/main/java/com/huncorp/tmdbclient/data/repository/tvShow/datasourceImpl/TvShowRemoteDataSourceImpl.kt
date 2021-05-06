package com.huncorp.tmdbclient.data.repository.tvShow.datasourceImpl

import com.huncorp.tmdbclient.data.api.TMDBService
import com.huncorp.tmdbclient.data.model.tvShow.TvShowList
import com.huncorp.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShow(apiKey)
}
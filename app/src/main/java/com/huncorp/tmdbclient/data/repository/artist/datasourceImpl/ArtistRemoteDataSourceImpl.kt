package com.huncorp.tmdbclient.data.repository.artist.datasourceImpl

import com.huncorp.tmdbclient.data.api.TMDBService
import com.huncorp.tmdbclient.data.model.artist.ArtistList
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}
package com.huncorp.tmdbclient.data.repository.artist

import com.huncorp.tmdbclient.data.api.TMDBService
import com.huncorp.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}
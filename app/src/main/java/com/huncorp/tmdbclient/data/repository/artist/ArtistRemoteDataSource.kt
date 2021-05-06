package com.huncorp.tmdbclient.data.repository.artist

import com.huncorp.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}
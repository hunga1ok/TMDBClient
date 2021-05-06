package com.huncorp.tmdbclient.domain.repository

import com.huncorp.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}
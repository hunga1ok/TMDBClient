package com.huncorp.tmdbclient.data.repository.artist

import com.huncorp.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromLocal(): List<Artist>
    suspend fun saveArtistsToLocal(artists: List<Artist>)
    suspend fun clearAll()
}
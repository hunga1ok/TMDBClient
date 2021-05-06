package com.huncorp.tmdbclient.data.repository.artist.datasourceImpl

import com.huncorp.tmdbclient.data.db.ArtistDao
import com.huncorp.tmdbclient.data.model.artist.Artist
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromLocal(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistsToLocal(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}
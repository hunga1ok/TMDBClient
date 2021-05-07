package com.huncorp.tmdbclient.data.repository.artist

import android.util.Log
import com.huncorp.tmdbclient.data.model.artist.Artist
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.huncorp.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToLocal(newListArtists)
        artistCacheDataSource.saveArtistsToCache(newListArtists)
        return newListArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artists = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return artists
    }

    suspend fun getArtistsFromLocal(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistLocalDataSource.getArtistsFromLocal()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (artists.isEmpty()) {
            artists = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToLocal(artists)
        }

        return artists
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (artists.isEmpty()) {
            artists = getArtistsFromLocal()
            artistCacheDataSource.saveArtistsToCache(artists)
        }

        return artists
    }
}
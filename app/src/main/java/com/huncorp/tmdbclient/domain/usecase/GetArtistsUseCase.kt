package com.huncorp.tmdbclient.domain.usecase

import com.huncorp.tmdbclient.data.model.artist.Artist
import com.huncorp.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistsRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistsRepository.getArtist()
}
package com.huncorp.tmdbclient.domain.usecase

import com.huncorp.tmdbclient.data.model.artist.Artist
import com.huncorp.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}
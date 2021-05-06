package com.huncorp.tmdbclient.domain.usecase

import com.huncorp.tmdbclient.data.model.tvShow.TvShow
import com.huncorp.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}
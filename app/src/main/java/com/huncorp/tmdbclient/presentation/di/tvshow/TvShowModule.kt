package com.huncorp.tmdbclient.presentation.di.tvshow

import com.huncorp.tmdbclient.domain.usecase.GetArtistsUseCase
import com.huncorp.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.huncorp.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.huncorp.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.huncorp.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.huncorp.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}
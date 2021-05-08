package com.huncorp.tmdbclient.presentation.di.artist

import com.huncorp.tmdbclient.domain.usecase.GetArtistsUseCase
import com.huncorp.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.huncorp.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}
package com.huncorp.tmdbclient.presentation.di.movie

import com.huncorp.tmdbclient.domain.usecase.GetMoviesUseCase
import com.huncorp.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.huncorp.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}
package com.huncorp.tmdbclient.presentation.di.core

import com.huncorp.tmdbclient.data.api.TMDBService
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.huncorp.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.huncorp.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.huncorp.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.huncorp.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import com.huncorp.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}
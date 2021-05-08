package com.huncorp.tmdbclient.presentation.di.core

import com.huncorp.tmdbclient.data.db.ArtistDao
import com.huncorp.tmdbclient.data.db.MovieDao
import com.huncorp.tmdbclient.data.db.TvShowDao
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.huncorp.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.huncorp.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.huncorp.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.huncorp.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDataSource
import com.huncorp.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}
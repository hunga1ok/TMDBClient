package com.huncorp.tmdbclient.presentation.di.core

import com.huncorp.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.huncorp.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.huncorp.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.huncorp.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.huncorp.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDataSource
import com.huncorp.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}
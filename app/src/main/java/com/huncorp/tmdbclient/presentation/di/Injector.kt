package com.huncorp.tmdbclient.presentation.di

import com.huncorp.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.huncorp.tmdbclient.presentation.di.movie.MovieSubComponent
import com.huncorp.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}
package com.huncorp.tmdbclient.data.repository.movie.datasource

import com.huncorp.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}
package com.huncorp.tmdbclient.domain.usecase

import com.huncorp.tmdbclient.data.model.movie.Movie
import com.huncorp.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}
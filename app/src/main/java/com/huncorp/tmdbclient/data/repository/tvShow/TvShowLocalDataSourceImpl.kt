package com.huncorp.tmdbclient.data.repository.tvShow

import com.huncorp.tmdbclient.data.db.TvShowDao
import com.huncorp.tmdbclient.data.model.tvShow.TvShow

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromLocal(): List<TvShow> {
        return tvShowDao.getTvShow()
    }

    override suspend fun saveTvShowsToLocal(tvShows: List<TvShow>) {
        tvShowDao.deleteAllTvShow()
        tvShowDao.saveTvShows(tvShows)
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTvShow()
    }
}
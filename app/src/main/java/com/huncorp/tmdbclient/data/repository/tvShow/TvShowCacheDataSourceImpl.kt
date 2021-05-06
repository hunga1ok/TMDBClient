package com.huncorp.tmdbclient.data.repository.tvShow

import com.huncorp.tmdbclient.data.model.tvShow.TvShow

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
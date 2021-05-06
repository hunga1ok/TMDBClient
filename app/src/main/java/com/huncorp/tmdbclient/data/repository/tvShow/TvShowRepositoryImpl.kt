package com.huncorp.tmdbclient.data.repository.tvShow

import android.util.Log
import com.huncorp.tmdbclient.data.model.tvShow.TvShow
import com.huncorp.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvShowFromApi()
        tvShowLocalDataSource.saveTvShowsToLocal(newTvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowFromLocal(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromLocal()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTvShowFromApi()
        }

        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTvShowFromLocal()
        }

        return tvShowList
    }
}
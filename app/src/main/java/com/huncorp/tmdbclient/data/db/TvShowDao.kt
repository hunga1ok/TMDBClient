package com.huncorp.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.huncorp.tmdbclient.data.model.tvShow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShow(tvShows: List<TvShow>)
}
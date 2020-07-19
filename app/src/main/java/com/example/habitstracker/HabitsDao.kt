package com.example.habitstracker

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface HabitsDao {

    @Query("SELECT * from habits_table ORDER BY nama ASC")
    fun getAlphabetizedWords(): LiveData<List<Habits>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(habits: Habits)

    @Query("DELETE FROM habits_table")
    suspend fun deleteAll()

    @Update
    suspend fun update(habits: Habits)

    @Delete
    suspend fun delete(habits: Habits)
}
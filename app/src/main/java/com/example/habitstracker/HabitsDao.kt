package com.mochamadfghd.habitstracker

import androidx.lifecycle.LiveData
import androidx.room.*

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

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

    @Query("DELETE FROM habits_table where id = :id")
    suspend fun delete(id:String)
}
package com.example.habitstracker

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface HabitsDao {
    @Insert
    fun tambahHabits(habitsEntity: Habits?)

    @Delete
    fun hapusHabits(habitsEntity: Habits?)

    @Query("SELECT * FROM Habits")
    fun tampilSeluruhHabits(): List<Habits>

    @Query("SELECT * FROM Habits WHERE nama LIKE :nama")
    fun findByNama(nama: String?): List<Habits>
}
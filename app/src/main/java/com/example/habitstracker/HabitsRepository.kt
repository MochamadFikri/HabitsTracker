package com.mochamadfghd.habitstracker

import androidx.lifecycle.LiveData

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

class HabitsRepository(private val habitsDao: HabitsDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allHabits: LiveData<List<Habits>> = habitsDao.getAlphabetizedWords()

    suspend fun insert(habits: Habits) {
        habitsDao.insert(habits)
    }


    suspend fun update(habits: Habits) {
        habitsDao.update(habits)
    }


    suspend fun delete(habits: Habits) {
        habitsDao.delete(habits.id)
    }
}
package com.example.habitstracker

import androidx.room.*


@Database(entities = [Habits::class], version = 1)
abstract class HabitsDatabase : RoomDatabase() {
    abstract fun habitsDao(): HabitsDao?
}
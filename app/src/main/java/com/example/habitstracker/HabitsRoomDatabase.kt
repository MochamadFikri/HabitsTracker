package com.example.habitstracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KParameter

@Database(entities = arrayOf(Habits::class), version = 3, exportSchema = false)
abstract class HabitsRoomDatabase : RoomDatabase() {

    abstract fun habitsDao(): HabitsDao

    private class HabitsDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var habitsDao = database.habitsDao()
                    //habitsDao.deleteAll()
                    // Add sample words.
                    //var habits = Habits("Sholat Subuh","04:00")
                    //habitsDao.insert(habits)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: HabitsRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): HabitsRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HabitsRoomDatabase::class.java,
                    "habits_database"
                )
                    .addCallback(HabitsDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
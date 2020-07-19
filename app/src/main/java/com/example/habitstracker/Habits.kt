package com.example.habitstracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "habits_table")
class Habits(
    @PrimaryKey
    @ColumnInfo(name = "nama") val nama: String,
    @ColumnInfo(name = "waktu") val waktu: String
)
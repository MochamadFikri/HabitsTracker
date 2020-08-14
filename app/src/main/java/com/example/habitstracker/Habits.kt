package com.mochamadfghd.habitstracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

@Entity(tableName = "habits_table")
class Habits(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "nama") val nama: String,
    @ColumnInfo(name = "waktu") val waktu: String
)
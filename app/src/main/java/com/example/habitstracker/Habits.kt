package com.example.habitstracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Habits (
    @PrimaryKey @ColumnInfo(name = "nama")
    var nama: String
)
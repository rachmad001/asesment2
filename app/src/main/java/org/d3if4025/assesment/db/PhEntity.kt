package org.d3if4025.assesment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ph")
data class PhEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0L,
    val ph: Float,
    val kategori: String
)
package org.d3if4025.assesment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhDao {
    @Insert
    fun insert(ph: PhEntity)

    @Query("SELECT * FROM ph")
    fun getPh(): LiveData<PhEntity?>
}
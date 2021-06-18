package org.d3if4025.assesment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PhEntity::class], version = 1, exportSchema = false)
abstract class PhDb : RoomDatabase() {
    abstract val dao : PhDao

    companion object {
        @Volatile
        private var INSTANCE: PhDb? = null

        fun getInstance(context: Context): PhDb {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhDb::class.java,
                        "ph.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
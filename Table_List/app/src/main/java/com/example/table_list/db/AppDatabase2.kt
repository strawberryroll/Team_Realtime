package com.example.table_list.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ProductEntity::class),version = 1) // ❶ 조건 1
abstract class AppDatabase2 : RoomDatabase() { // ❷ 조건 2

    abstract fun getProductDao() : ProductDao // ❸ 조건 3

    companion object {
        val databaseName = "db_product" // 데이터베이스 이름입니다. 임의로 지정해주어도 됩니다.
        var appDatabase : AppDatabase2? = null

        fun getInstance(context : Context) : AppDatabase2? {
            if(appDatabase == null){
                appDatabase =  Room.databaseBuilder(context,
                    AppDatabase2::class.java,
                    databaseName).
                fallbackToDestructiveMigration()
                    .build()
            }
            return  appDatabase
        }
    }

}
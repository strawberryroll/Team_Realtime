package com.example.table_list.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TableDao {
    @Query("SELECT * FROM TableEntity")
    fun getAll() : List<TableEntity>

    @Insert
    fun insertTable(todo: TableEntity)

    @Delete
    fun deleteTable(todo : TableEntity)
}
package com.example.table_list.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM ProductEntity")
    fun getAll2() : List<ProductEntity>

    @Insert
    fun insertProduct(todo: ProductEntity)

    @Delete
    fun deleteProduct(todo : ProductEntity)
}
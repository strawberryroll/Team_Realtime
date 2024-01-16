package com.example.table_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.table_list.databinding.ActivityAddTableBinding
import com.example.table_list.db.AppDatabase
import com.example.table_list.db.TableDao
import com.example.table_list.db.TableEntity


class AddTableActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddTableBinding
    lateinit var db : AppDatabase
    lateinit var tableDao: TableDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)!!
        tableDao = db.getTableDao()

        binding.btnCompletion.setOnClickListener {
            insertTable()
        }
    }

    private fun insertTable() {

        val tableTitle = binding.edtTitle.text.toString()

        if (tableTitle.isBlank()) {
            Toast.makeText(this, "항목을 채워주세요.", Toast.LENGTH_SHORT).show()
        } else {
            Thread {
                tableDao.insertTable(TableEntity(null, tableTitle))
                runOnUiThread {
                    Toast.makeText(this, "추가되었습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }.start()
        }
    }
}
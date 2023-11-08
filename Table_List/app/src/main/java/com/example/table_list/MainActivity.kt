package com.example.table_list

import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.table_list.databinding.ActivityMainBinding
import com.example.table_list.db.AppDatabase
import com.example.table_list.db.TableDao
import com.example.table_list.db.TableEntity
import android.widget.Button
import android.widget.Toolbar
import android.widget.Toolbar.OnMenuItemClickListener


class MainActivity : AppCompatActivity(), OnItemLongClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var db : AppDatabase
    private lateinit var tableDao : TableDao
    private lateinit var tableList : ArrayList<TableEntity>
    private lateinit var adapter: TableRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddTableActivity::class.java)
            startActivity(intent)
        }

        binding.toolbar.title = "Realtime"
        binding.toolbar.inflateMenu(R.menu.main_menu)

        db = AppDatabase.getInstance(this)!!
        tableDao = db.getTableDao()

        getAllTableList()

        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_btn2 -> {
                    val intent = Intent(this, ProductActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_btn1 -> {
                    false
                }
                else -> {
                    false
                }
            }

        }

    }



    private fun getAllTableList(){
        Thread{
            tableList = ArrayList(tableDao.getAll())
            setRecyclerView()
        }.start()
    }

    private fun setRecyclerView() {
        runOnUiThread {
            adapter = TableRecyclerViewAdapter(tableList, this)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onRestart() {
        super.onRestart()
        getAllTableList()
    }

    override fun onLongClick(position: Int) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("테이블 삭제")
        builder.setMessage("정말 삭제하시겠습니까?")
        builder.setNegativeButton("취소", null)
        builder.setPositiveButton("네",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    deleteTodo(position)
                }
            }
        )
        builder.show()
    }

    private fun deleteTodo(position: Int) {
        Thread {
            tableDao.deleteTable(tableList[position]) // DB에서 삭제
            tableList.removeAt(position) // 리스트에서 삭제
            runOnUiThread { // UI 관련 작업은 UI 스레드에서
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    */




/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        when(item.itemId){
            R.id.action_btn1 -> { return super.onOptionsItemSelected(item) }
            R.id.action_btn2 -> { return super.onOptionsItemSelected(item) }
            else -> {return super.onOptionsItemSelected(item)}



        }
    }
*/

}


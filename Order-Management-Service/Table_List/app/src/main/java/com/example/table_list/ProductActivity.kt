package com.example.table_list

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.table_list.databinding.ActivityProductBinding
import com.example.table_list.db.AppDatabase2
import com.example.table_list.db.ProductDao
import com.example.table_list.db.ProductEntity
import java.nio.file.Files.delete


class ProductActivity : AppCompatActivity(), OnItemLongClickListener {

    private lateinit var binding: ActivityProductBinding

    private lateinit var db : AppDatabase2
    private lateinit var productDao : ProductDao
    private lateinit var productList : ArrayList<ProductEntity>
    private lateinit var adapter : ProductRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddProduct.setOnClickListener{
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        }

        binding.toolbar.title = "Realtime"
        binding.toolbar.inflateMenu(R.menu.main_menu)

        db = AppDatabase2.getInstance(this)!!
        productDao = db.getProductDao()

        getAllProductList()

        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_btn1 -> {
                    val intent = Intent(this, MainActivity::class.java)
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

    private fun getAllProductList() {
        Thread {
            productList = ArrayList(productDao.getAll2())
            setRecyclerView()
        }.start()
    }

    private fun setRecyclerView() {
        // 리사이클러뷰 설정
        runOnUiThread {
            adapter = ProductRecyclerViewAdapter(productList, this)
            binding.recyclerView2.adapter = adapter
            // 리사이클러뷰 어댑터로 위에서 만든 어댑터 설정
            binding.recyclerView2.layoutManager = LinearLayoutManager(this)
            // 레이아웃 매니저 설정
        }

    }

    override fun onRestart() {
        super.onRestart()
        getAllProductList()
    }

    override fun onLongClick(position: Int) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("상품 삭제")
        builder.setMessage("정말 삭제하시겠습니까?")
        builder.setNegativeButton("취소", null)
        builder.setPositiveButton("네",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    deleteProduct(position)
                }
            }
        )
        builder.show()
    }

    private fun deleteProduct(position: Int) {
        Thread {
            productDao.deleteProduct(productList[position]) // DB에서 삭제
            productList.removeAt(position) // 리스트에서 삭제
            runOnUiThread { // UI 관련 작업은 UI 스레드에서
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

}
package com.example.table_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.table_list.databinding.ActivityAddProductBinding
import com.example.table_list.db.AppDatabase2
import com.example.table_list.db.ProductDao
import com.example.table_list.db.ProductEntity

class AddProductActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddProductBinding
    lateinit var db : AppDatabase2
    lateinit var productDao: ProductDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase2.getInstance(this)!!
        productDao = db.getProductDao()

        binding.btnCompletionProduct.setOnClickListener {
            insertProduct()
        }
    }

    private fun insertProduct() {

        val productName = binding.edtTitleProduct1.text.toString()
        val productPrice = binding.edtTitleProduct2.text.toString()


        if (productName.isBlank() || productPrice.isBlank()) {
            Toast.makeText(this, "항목을 채워주세요.", Toast.LENGTH_SHORT).show()
        } else {
            Thread {
                productDao.insertProduct(ProductEntity(null, productName, productPrice))
                runOnUiThread {
                    Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }.start()
        }
    }
}


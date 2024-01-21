package com.example.table_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.table_list.databinding.ItemProductBinding
import com.example.table_list.db.ProductEntity

class ProductRecyclerViewAdapter(private val productList: ArrayList<ProductEntity>,
    private val listener: OnItemLongClickListener)
:RecyclerView.Adapter<ProductRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        val tv_name = binding.tvName
        val tv_price = binding.tvPrice

        // 뷰 바인딩에서 기본적으로 제공하는 root 변수는 레이아웃의 루트 레이아웃을 의미합니다.
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // item_product.xml 바인딩 객체 생성
        val binding: ItemProductBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val productData = productList[position]

        // 상품 이름 변경
        holder.tv_name.text = productData.name
        //상품 가격 변경
        holder.tv_price.text = productData.price


        //테이블이 길게 클릭되었을 때 리스너 함수 실행
        holder.root.setOnLongClickListener {
            listener.onLongClick(position)
            false
        }
    }

    override fun getItemCount(): Int {
        // 리사이클러뷰 아이템 개수는 할 일 리스트의 크기
        return productList.size
    }
}
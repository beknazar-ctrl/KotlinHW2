package com.example.kotlinhw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinhw2.extension.load
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*

class MainActivity : AppCompatActivity() {

    var imgUrls:ArrayList<String> = ArrayList()
    var recyclerView:RecyclerView? = null
    var adapter: ImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgUrls = arrayListOf("https://cdn.pixabay.com/photo/2017/09/11/15/58/sunset-2739472_1280.jpg",
        "https://cdn.pixabay.com/photo/2018/07/24/15/59/bremen-3559469_1280.jpg",
            "https://cdn.pixabay.com/photo/2021/08/04/14/21/lighthouse-6521858_1280.jpg",
        "https://cdn.pixabay.com/photo/2021/05/22/10/11/fishing-boat-6273132__480.jpg")

        btn_random.setOnClickListener{
            imgUrls.shuffle()
            adapter?.notifyDataSetChanged()
        }

        btn_submit.setOnClickListener{
            if (!ed_url.text.isNullOrBlank()){
                imgUrls.add(ed_url.text.toString())
                adapter?.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"empty",Toast.LENGTH_SHORT).show()
            }
        }

        recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        recyclerView!!.layoutManager = GridLayoutManager(this,2)
        adapter = ImageAdapter(imgUrls)
        recyclerview!!.adapter = adapter

    }
}
package com.example.kotlinhw2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhw2.extension.load


class ImageAdapter(private val imgUrl:ArrayList<String>):RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.img.load(imgUrl[position])
    }

    override fun getItemCount(): Int {
       return imgUrl.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img: ImageView

        init {
            img = itemView.findViewById(R.id.imageView) as ImageView
        }

    }
}

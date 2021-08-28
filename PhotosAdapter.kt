package com.example.retrofitapi

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhotosAdapter(var imageViewList: List<Images>):RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        var itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.photos_resouce_file,parent,false)
        return PhotosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
    var current=imageViewList.get(position)

        holder.textView.text=current.caption

    Picasso.get()
            .load(current.imageUrl)
            .resize(80,80)
            .centerCrop()
            .into(holder.image)
    }

    override fun getItemCount(): Int {
    return imageViewList.size
    }
}
class PhotosViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var image=itemView.findViewById<ImageView>(R.id.imageView3)
    var textView = itemView.findViewById<TextView>(R.id.textView)
}
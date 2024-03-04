package com.dicoding.hololiveen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListVtuberAdapter(private val listVtuber: ArrayList<Holoen>) : RecyclerView.Adapter<ListVtuberAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_holoen, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listVtuber.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listVtuber[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listVtuber[holder.adapterPosition]) }


//        holder.itemView.setOnClickListener {
//            val intentContent = Intent(holder.itemView.context, contentMember::class.java)
//            holder.itemView.context.startActivity(intentContent)
//        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Holoen)
    }
}
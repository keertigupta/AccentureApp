package com.example.accenturerestapidemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.accenturerestapidemo.R
import com.example.accenturerestapidemo.model.Rows
import java.util.*


class DemoListAdapter(
    private val context: Context,
    private val projectArrayList: ArrayList<Rows>
) : RecyclerView.Adapter<DemoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val imagePath =projectArrayList[position].imageHref
        holder.tvprojectname.text = projectArrayList[position].title
        holder.titleDes.text = projectArrayList[position].description
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_launcher_background)
        //requestOptions.error(R.drawable.ic_error)
        Glide.with(context).setDefaultRequestOptions(requestOptions)
            .load(imagePath)
         //   .placeholder(R.drawable.loading)
            .into(holder.rowImage)
    }

    override fun getItemCount(): Int {
        return projectArrayList.size
    }

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {

        var rowImage: ImageView
        var tvprojectname :TextView
        var titleDes:TextView
        init {
            rowImage = itemView.findViewById<View>(R.id.ivProject) as ImageView
            tvprojectname = itemView.findViewById<View>(R.id.tv_tittle) as TextView
            titleDes = itemView.findViewById(R.id.title_des)
        }
    }

}
package com.reza.base.presentation.homepage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.base.R
import com.reza.base.entity.MovieItem
import com.reza.base.presentation.detailpage.DetailPageActivity


/**
 * Created by Reza Kurniawan on 28/03/2019.
 */

class HomePageItemListAdapter(private val context: Context, private val apiObjectList: List<MovieItem>) :
        RecyclerView.Adapter<HomePageItemListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageItemListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_page_list, parent, false)
        return HomePageItemListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (title, image, price) = this.apiObjectList[position]
        holder.title?.text = title
        holder.price?.text = price
        holder.bindItem(this.apiObjectList[position])

        Glide.with(holder.itemView.context)
                .load(image)
                .into(holder.image!!)
    }

    override fun getItemCount(): Int {
        return apiObjectList.size
    }

    class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        var title: TextView? = null
        var image: ImageView? = null
        var price: TextView? = null

        init {
            title = itemView.findViewById(R.id.txt_title) as TextView
            price = itemView.findViewById(R.id.txt_price) as TextView
            image = itemView.findViewById(R.id.iv_image) as ImageView
        }

        fun bindItem(movieItem: MovieItem) {
            itemView.setOnClickListener {
                DetailPageActivity.startThisActivity(itemView.context)
            }
        }
    }
}
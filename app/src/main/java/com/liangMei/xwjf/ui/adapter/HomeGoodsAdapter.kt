package com.liangMei.xwjf.ui.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liangMei.xwjf.R
import kotlinx.android.synthetic.main.item_home.view.*

class HomeGoodsAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val mAdapter by lazy { HomeItemAdapter(context) }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.apply {
            item_rl.layoutManager = GridLayoutManager(context, 2)
            item_rl.adapter = mAdapter
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
package com.liangMei.xwjf.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liangMei.xwjf.R

class IntegralGoodsAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_integral_goods, parent, false)
        return HomeGoodsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = 12

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
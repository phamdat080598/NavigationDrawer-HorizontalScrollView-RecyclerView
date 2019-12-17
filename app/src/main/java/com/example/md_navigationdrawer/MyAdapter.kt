package com.example.md_navigationdrawer

import android.annotation.SuppressLint
import android.content.ClipData
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(var list: MutableList<model>, var listener: OnClickItem) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var oldView: CardView? = null
    //    private val TYPE_HEADER = 1
//    private val TYPE_ITEM = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        if(viewType==TYPE_HEADER){
//            val view:View = LayoutInflater.from(parent.context).inflate(R.layout.header_row,parent,false)
//            return MyViewHolder1(view)
//        }else{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder2(view)
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder2) {
            holder.bind(list.get(position), listener)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

//    override fun getItemViewType(position: Int): Int {
//        if(checkHeader(position)){
//            return TYPE_HEADER
//        }else{
//            return TYPE_ITEM
//        }
//    }

    //    private fun checkHeader(possition: Int):Boolean{
//        if(possition==0){
//            return true
//        }
//        return false
//    }
    inner class MyViewHolder2(var item1: View) : RecyclerView.ViewHolder(item1) {
        @SuppressLint("ResourceAsColor")
        fun bind(model: model, listener: OnClickItem) {
            item1.boq_label.text = model.s1
            item1.boq_title.text = model.s2
            item1.boq_unit.text = model.s3
            item1.boq_quantity.text = model.s4
            item1.boq_rate.text = model.s5
            item1.rateIn.text = model.s6
            item1.amo.text = model.s7
            item1.remarks.text = model.s8
            item1.setOnClickListener {
                if (oldView != null) {
                    oldView?.setCardBackgroundColor(Color.WHITE)
                }
                item1.cardView.setCardBackgroundColor(R.color.colorPrimary)
                oldView = item1.cardView
                listener.onClick(model)
            }
        }
    }

//    inner class MyViewHolder1(item:View):RecyclerView.ViewHolder(item) {
//    }

    interface OnClickItem {
        fun onClick(model: model)
    }

}

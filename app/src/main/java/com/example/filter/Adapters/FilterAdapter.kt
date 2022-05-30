package com.example.filter.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filter.DataClass.Filter
import com.example.filter.R

class FilterAdapter(private val listener:(Filter) -> Unit):RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {

    var filterData= arrayOf<Filter>()
    set(value) {
        field=value
        notifyDataSetChanged()
    }

    inner class FilterViewHolder(view: View):RecyclerView.ViewHolder(view){
        val interestText:TextView=view.findViewById(R.id.interest_text)
        init {
            itemView.setOnClickListener {
                listener.invoke(filterData[absoluteAdapterPosition])
            }
        }
    }

    override fun getItemCount() = filterData.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val itemLayout=LayoutInflater.from(parent.context).inflate(R.layout.filter_item,parent,false)

        return FilterViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        with(holder){
            interestText.text=filterData[position].filterText
        }
    }



    override fun getItemId(position: Int): Long {
        return filterData[position].hashCode().toLong()
    }
}
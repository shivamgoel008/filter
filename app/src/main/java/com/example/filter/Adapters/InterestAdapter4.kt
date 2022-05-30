package com.example.filter.Adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.filter.DataClass.Interest
import com.example.filter.R


class InterestAdapter4: RecyclerView.Adapter<InterestAdapter4.InterestViewHolder>() {
    var interestData= arrayOf<Interest>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }

    class InterestViewHolder(view: View): RecyclerView.ViewHolder(view){
        val interestImage: ImageView =view.findViewById(R.id.interest_img)
    }

    override fun getItemCount() = interestData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestViewHolder {
        val itemLayout=
            LayoutInflater.from(parent.context).inflate(R.layout.interest_item,parent,false)

        return InterestViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: InterestViewHolder, position: Int) {
        with(holder){
            interestImage.setImageResource(interestData[position].interestImage)
        }
    }

    override fun getItemId(position: Int): Long {
        return interestData[position].hashCode().toLong()
    }
}
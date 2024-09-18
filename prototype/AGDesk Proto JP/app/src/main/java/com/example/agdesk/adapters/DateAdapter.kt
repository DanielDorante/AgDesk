package com.example.agdesk.adapters

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateAdapter(
    private val dates: List<Long>,
    var onSelected: OnSelected
) : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    // Index of the selected date
    var selected: Int = 0

    // Set the selected date index
    fun setSelectedPosition(selected: Int) {
        this.selected = selected
        notifyDataSetChanged()
    }

    // Get the selected date index
    fun getSelectedPosition(): Int {
        return selected
    }

    interface OnSelected {
        fun onSelected(data: Long)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_date_layout, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DateViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val dateInMillis = dates[position]
        holder.bind(dateInMillis)

        if (selected == position) {
            holder.dateTextView.backgroundTintList =
                ColorStateList.valueOf(holder.itemView.context.getColor(R.color.main))
            holder.topView.setBackgroundColor(holder.itemView.context.getColor(R.color.dark_main))
            holder.dateTextView.setTextColor(holder.itemView.context.getColor(R.color.white))

        } else {
            holder.dateTextView.backgroundTintList =
                ColorStateList.valueOf(holder.itemView.context.getColor(R.color.white))
            holder.topView.setBackgroundColor(holder.itemView.context.getColor(R.color.main))
            holder.dateTextView.setTextColor(holder.itemView.context.getColor(R.color.main))

        }
        holder.itemView.setOnClickListener {
            if (selected == position) return@setOnClickListener
            val previousSelected = selected
            selected = position
            notifyItemChanged(position)
            onSelected.onSelected(dateInMillis)
            notifyItemChanged(previousSelected)
        }
    }

    override fun getItemCount(): Int = dates.size

    class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val topView: View = itemView.findViewById(R.id.topView) // Reference the top view (vieww)


        fun bind(dateInMillis: Long) {
            // Date format for day and date
            val dayFormat = SimpleDateFormat("EEE", Locale.getDefault()) // Get day (Mon, Tue, etc.)
            val dateFormat = SimpleDateFormat("dd ", Locale.getDefault()) // Get date (01 Jan, etc.)

            // Get the formatted day and date
            val day = dayFormat.format(Date(dateInMillis))
            val date = dateFormat.format(Date(dateInMillis))

            // Set the text with day on top and date on a new line
            dateTextView.text = "$date\n$day"
        }
    }
}

package com.example.agdesk.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import com.example.agdesk.models.InventoryModel
import com.example.agdesk.models.TaskModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class InventoryAdapter(
    private var inventoryList: List<InventoryModel>,
) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

    fun setList(inventoryList: List<InventoryModel>) {
        this.inventoryList = inventoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_inventory, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val inventory = inventoryList[position]
        holder.bind(inventory)

    }

    override fun getItemCount(): Int = inventoryList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)

        fun bind(inventory: InventoryModel) {
            tvName.text = inventory.name
            tvQuantity.text = inventory.quantity

        }

    }

}

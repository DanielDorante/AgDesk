package com.example.agdesk.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import com.example.agdesk.models.UIModels.InventoryModel

class InventoryAdapter(
    private var inventoryList: List<InventoryModel>,
    private val onItemClick: (InventoryModel) -> Unit = {},
    private val onDeleteClick: (InventoryModel) -> Unit = {}
) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

    interface InventoryItemListener {
        fun onEditClick(inventory: InventoryModel)
        fun onDeleteClick(inventory: InventoryModel)
    }

    private var inventoryListener: InventoryItemListener? = null

    // Constructor with listener
    constructor(
        inventoryList: List<InventoryModel>,
        listener: InventoryItemListener
    ) : this(inventoryList, {}, {}) {
        this.inventoryListener = listener
    }

    fun setList(inventoryList: List<InventoryModel>) {
        this.inventoryList = inventoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_inventory, parent, false)
        return ViewHolder(view)
    }    override fun onBindViewHolder(
        holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val inventory = inventoryList[position]
        holder.bind(inventory)

        // Set click listener for the entire item
        holder.itemView.setOnClickListener {
            onItemClick(inventory)
        }

        // Set up menu button for popup actions
        holder.btnMenu?.setOnClickListener { view ->
            // Create and show the popup menu
            val popupMenu = android.widget.PopupMenu(view.context, view)
            popupMenu.menuInflater.inflate(R.menu.inventory_item_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_edit -> {
                        // Use inventory listener if available, otherwise fallback to click handler
                        if (inventoryListener != null) {
                            inventoryListener?.onEditClick(inventory)
                        } else {
                            onItemClick(inventory)
                        }
                        true
                    }
                    R.id.menu_delete -> {
                        // Use inventory listener if available, otherwise fallback to delete handler
                        if (inventoryListener != null) {
                            inventoryListener?.onDeleteClick(inventory)
                        } else {
                            onDeleteClick(inventory)
                        }
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }

    override fun getItemCount(): Int = inventoryList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val btnMenu: ImageButton? = itemView.findViewById(R.id.btnInventoryMenu)

        fun bind(inventory: InventoryModel) {
            tvName.text = inventory.name
            tvQuantity.text = inventory.quantity.toString()
        }
    }
}

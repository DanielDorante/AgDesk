package com.example.agdesk.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agdesk.R
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.OnClick
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AssetsAdapter(
    var context: Context,
    private var assetsList: List<AssetModel>,
    private var onClick: OnClick
) : RecyclerView.Adapter<AssetsAdapter.ViewHolder>() {

    fun setList(taskList: List<AssetModel>) {
        this.assetsList = taskList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_asset, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val asset = assetsList[position]
        holder.bind(asset, context)

        holder.itemView.setOnClickListener {
            onClick.clicked(position)
        }

    }

    override fun getItemCount(): Int = assetsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val ivImage: ImageView = itemView.findViewById(R.id.ivImage)

        fun bind(task: AssetModel, context: Context) {
            tvName.text = task.name
            tvLocation.text = task.location
            if (!task.checkoutStatus!!){
                tvStatus.text = "Checked in"
                tvStatus.setTextColor(context.getColor(R.color.dark_main))
            }else{
                tvStatus.text = "Checked out"
                tvStatus.setTextColor(context.getColor(R.color.red))
            }
            Glide.with(ivImage).load(task.image).into(ivImage)

        }

        private fun formatDate(dateStr: String): String {
            val inputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val outputFormat = SimpleDateFormat("d\nMMM", Locale.getDefault())
            val date: Date? = inputFormat.parse(dateStr)
            return if (date != null) outputFormat.format(date) else dateStr
        }

    }

}

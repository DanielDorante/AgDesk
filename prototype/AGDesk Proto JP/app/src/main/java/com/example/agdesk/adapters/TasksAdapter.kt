package com.example.agdesk.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import com.example.agdesk.models.TaskModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TasksAdapter(
    private var taskList: List<TaskModel>,
    private val isHomeFragment: Boolean
) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    fun setList(taskList: List<TaskModel>) {
        this.taskList = taskList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val task = taskList[position]
        holder.bind(task, isHomeFragment)


    }

    override fun getItemCount(): Int = taskList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvTaskDate: TextView = itemView.findViewById(R.id.tvTaskDate)
        val tvTaskTime: TextView = itemView.findViewById(R.id.tvTaskTime)
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.rlItemTask)

        fun bind(task: TaskModel, isHomeFragment: Boolean) {
            tvName.text = task.name
            tvTaskDate.text = formatDate(task.date.toString())
            tvTaskTime.text = task.time

            // Change background color based on the fragment
            if (isHomeFragment) {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.gray_card))
            } else {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.item_bg_green))
            }
        }

        private fun formatDate(dateStr: String): String {
            val inputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val outputFormat = SimpleDateFormat("d\nMMM", Locale.getDefault())
            val date: Date? = inputFormat.parse(dateStr)
            return if (date != null) outputFormat.format(date) else dateStr
        }

    }

}

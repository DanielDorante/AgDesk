package com.example.agdesk.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import com.example.agdesk.models.TaskModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TasksAdapter(
    private var taskList: List<TaskModel>,
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
        holder.bind(task)


    }

    override fun getItemCount(): Int = taskList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvTaskDate: TextView = itemView.findViewById(R.id.tvTaskDate)
        val tvTaskTime: TextView = itemView.findViewById(R.id.tvTaskTime)

        fun bind(task: TaskModel) {
            tvName.text = task.name
            tvTaskDate.text = formatDate(task.date.toString())
            tvTaskTime.text = task.time

        }

        private fun formatDate(dateStr: String): String {
            val inputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val outputFormat = SimpleDateFormat("d\nMMM", Locale.getDefault())
            val date: Date? = inputFormat.parse(dateStr)
            return if (date != null) outputFormat.format(date) else dateStr
        }

    }

}

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
import com.example.agdesk.models.UIModels.TaskModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TasksAdapter(
    private var taskList: List<TaskModel>,
    private val isHomeFragment: Boolean,
    private val taskListener: TaskItemListener? = null
) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    interface TaskItemListener {
        fun onEditClick(task: TaskModel)
        fun onDeleteClick(task: TaskModel)
    }

    fun setList(taskList: List<TaskModel>) {
        this.taskList = taskList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)

    }    override fun onBindViewHolder(
        holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        if (taskList.isEmpty()){
            return
        }
        val task = taskList[position]
        holder.bind(task, isHomeFragment)

        // Set listener for menu button
        holder.btnMenu.setOnClickListener { view ->
            taskListener?.let { listener ->
                // Show options dialog for edit/delete
                val popupMenu = android.widget.PopupMenu(holder.itemView.context, view)
                popupMenu.menuInflater.inflate(R.menu.task_item_menu, popupMenu.menu)
                popupMenu.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.menu_edit -> {
                            listener.onEditClick(task)
                            true
                        }
                        R.id.menu_delete -> {
                            listener.onDeleteClick(task)
                            true
                        }
                        else -> false
                    }
                }
                popupMenu.show()
            }
        }

        // Also keep long click listener for showing edit/delete options
        holder.itemView.setOnLongClickListener {
            taskListener?.let { listener ->
                // Show options dialog for edit/delete
                val popupMenu = android.widget.PopupMenu(holder.itemView.context, holder.itemView)
                popupMenu.menuInflater.inflate(R.menu.task_item_menu, popupMenu.menu)
                popupMenu.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.menu_edit -> {
                            listener.onEditClick(task)
                            true
                        }
                        R.id.menu_delete -> {
                            listener.onDeleteClick(task)
                            true
                        }
                        else -> false
                    }
                }
                popupMenu.show()
            }
            true
        }
    }

    override fun getItemCount(): Int = taskList.size    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvTaskDate: TextView = itemView.findViewById(R.id.tvTaskDate)
        val tvTaskTime: TextView = itemView.findViewById(R.id.tvTaskTime)
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.rlItemTask)
        val btnMenu: android.widget.ImageButton = itemView.findViewById(R.id.btnMenu)

        fun bind(task: TaskModel, isHomeFragment: Boolean) {
            tvName.text = task.name
            //tvTaskDate.text = formatDate(task.date.toString())
            //tvTaskTime.text = task.time //Needs Reformating to fit new TaskModel

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

package com.fourgauteau.os

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VistaNotificationAdapter(
    private var notifications: List<String>
) : RecyclerView.Adapter<VistaNotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val textView = TextView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setPadding(16, 12, 16, 12)
        }
        return NotificationViewHolder(textView)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.textView.text = notifications[position]
    }

    override fun getItemCount(): Int = notifications.size

    fun updateNotifications(newNotifications: List<String>) {
        notifications = newNotifications
        notifyDataSetChanged()
    }
}

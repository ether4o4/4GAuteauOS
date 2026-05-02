package com.fourgauteau.os

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fourgauteau.os.VistaLauncherActivity.VistaApp
import com.fourgauteau.os.databinding.VistaDesktopIconBinding

class VistaTaskbarAppAdapter(
    private var apps: List<VistaApp>,
    private val onAppClick: (VistaApp) -> Unit
) : RecyclerView.Adapter<VistaTaskbarAppAdapter.TaskbarViewHolder>() {

    class TaskbarViewHolder(
        private val binding: VistaDesktopIconBinding,
        private val onAppClick: (VistaApp) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(app: VistaApp) {
            binding.iconLabel.text = app.name
            binding.iconImage.setImageResource(app.iconRes)
            binding.root.setOnClickListener { onAppClick(app) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskbarViewHolder {
        val binding = VistaDesktopIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskbarViewHolder(binding, onAppClick)
    }

    override fun onBindViewHolder(holder: TaskbarViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount(): Int = apps.size

    fun updateApps(newApps: List<VistaApp>) {
        apps = newApps
        notifyDataSetChanged()
    }
}

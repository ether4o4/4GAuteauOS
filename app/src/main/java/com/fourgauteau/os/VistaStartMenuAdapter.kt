package com.fourgauteau.os

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fourgauteau.os.VistaLauncherActivity.VistaApp
import com.fourgauteau.os.databinding.VistaDesktopIconBinding

class VistaStartMenuAdapter(
    private var apps: List<VistaApp>,
    private val onAppClick: (VistaApp) -> Unit
) : RecyclerView.Adapter<VistaStartMenuAdapter.StartMenuViewHolder>() {

    class StartMenuViewHolder(
        private val binding: VistaDesktopIconBinding,
        private val onAppClick: (VistaApp) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(app: VistaApp) {
            binding.iconLabel.text = app.name
            binding.iconImage.setImageResource(app.iconRes)
            binding.root.setOnClickListener { onAppClick(app) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartMenuViewHolder {
        val binding = VistaDesktopIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StartMenuViewHolder(binding, onAppClick)
    }

    override fun onBindViewHolder(holder: StartMenuViewHolder, position: Int) {
        holder.bind(apps[position])
    }

    override fun getItemCount(): Int = apps.size

    fun updateApps(newApps: List<VistaApp>) {
        apps = newApps
        notifyDataSetChanged()
    }
}

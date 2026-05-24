package com.example.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.core.graphics.toColorInt

class ListAdapter(private  val itemList: List<ListItem>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: com.google.android.material.card.MaterialCardView = itemView.findViewById(R.id.cardView)
        val tvGambar: TextView = itemView.findViewById(R.id.tvGambar)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val switchAction: com.google.android.material.materialswitch.MaterialSwitch = itemView.findViewById(R.id.switchAction)
        val btnAction: Button = itemView.findViewById(R.id.btnAction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = itemList[position]

        holder.tvTitle.text = item.title
        holder.tvDescription.text = item.description

        holder.tvGambar.text = "Gambar\n${item.id}"

        if (position % 2 == 1) {
            holder.cardView.setBackgroundColor("#E8F5E9".toColorInt())
        } else {
            holder.cardView.setBackgroundColor(Color.WHITE)
        }

        holder.switchAction.setOnCheckedChangeListener(null)
        holder.switchAction.isChecked = false

        holder.switchAction.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(
                    holder.itemView.context,
                    "Switch hidup pada item ${item.id}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        holder.btnAction.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Tombol telah ditekan untuk tombol ${item.id}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = itemList.size
}
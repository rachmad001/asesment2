package org.d3if4025.assesment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import org.d3if4025.assesment.data.HasilPh
import org.d3if4025.assesment.databinding.ApiRowBinding

class AdapterApi : RecyclerView.Adapter<AdapterApi.ListViewHolder>() {

    private val data : MutableList<HasilPh> = mutableListOf<HasilPh>()

    fun updateData(newData: List<HasilPh>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ListViewHolder(private val binding: ApiRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ph: HasilPh){
            with(binding) {
                textView6.text = ph.notepad
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ApiRowBinding.inflate(inflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
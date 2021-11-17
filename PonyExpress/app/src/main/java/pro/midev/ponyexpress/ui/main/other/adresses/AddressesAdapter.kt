package pro.midev.ponyexpress.ui.main.other.adresses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.models.local.OrderLocal

class AddressesAdapter(
    val openDetail: ()->Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemHolder) holder.bind()//list[position])
    }

    override fun getItemCount(): Int = 43

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {//order: OrderLocal?) {
            with(itemView) {
                setOnClickListener {
                    openDetail()
                }
            }
        }
    }
}
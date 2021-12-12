package seftian.uts

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import seftian.uts.databinding.ItemCatBinding

class CatAdapter(private val listCat :ArrayList<CatDetail>,private val clickListener : (CatDetail)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding.root, parent.context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CatViewHolder
        viewHolder.bindView(listCat.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return listCat.size
    }


}
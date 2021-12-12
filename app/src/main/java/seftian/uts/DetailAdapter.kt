package seftian.uts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import seftian.uts.databinding.CatDetailBinding
import seftian.uts.databinding.ItemCatBinding

class DetailAdapter(private val listCat :ArrayList<CatImage>,private val clickListener : (CatImage)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CatDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding.root, parent.context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as DetailViewHolder

            viewHolder.bindView(listCat.get(position), clickListener)

        

    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    private var onClickListener : OnClickListener? = null

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int){
        }
    }

    fun replace(){

    }


}
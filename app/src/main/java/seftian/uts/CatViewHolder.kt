package seftian.uts

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import seftian.uts.databinding.ItemCatBinding

class CatViewHolder(itemView : View, private val context : Context): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemCatBinding.bind(itemView)

    fun bindView(catDetail: CatDetail,clickListener:(CatDetail)->Unit){

        binding.tvCatBreed.text = catDetail.name.toString()
        itemView.setOnClickListener{
        clickListener(catDetail)
}
    }









}
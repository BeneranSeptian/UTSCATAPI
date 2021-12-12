package seftian.uts

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import seftian.uts.databinding.CatDetailBinding

class DetailViewHolder(itemView : View, private val context : Context): RecyclerView.ViewHolder(itemView) {
    private val binding = CatDetailBinding.bind(itemView)

    fun bindView(catImage: CatImage,clickListener:(CatImage)->Unit){
        Glide.with(context)
            .load(catImage.url)
            .into(binding.ivCat)
        itemView.setOnClickListener{
            clickListener(catImage)
        }
    }




}
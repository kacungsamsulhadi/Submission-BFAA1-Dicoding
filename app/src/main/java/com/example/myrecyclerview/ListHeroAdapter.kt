package com.example.myrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.UserDetail.Companion.EXTRA_DATA
import com.example.myrecyclerview.databinding.ItemRowHeroBinding

class ListHeroAdapter : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>(){

    private val listHero = ArrayList<Hero>()

    @SuppressLint("NotifyDataSetChanged")
    fun setAllData(data: List<Hero>){
        listHero.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ListViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
    override fun getItemCount(): Int = listHero.size

    inner class ListViewHolder(private var view: ItemRowHeroBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(hero: Hero) {
            view.apply {
                tvItemName.text = hero.name
                tvItemDescription.text = hero.company
                tvItemLocation.text = hero.location
            }
            Glide.with(itemView.context)
                .load(hero.img)
                .apply(RequestOptions.circleCropTransform())
                .into(view.imgItemPhoto)

            itemView.setOnClickListener{
                val intent = Intent(itemView.context, UserDetail::class.java)
                intent.putExtra(EXTRA_DATA,hero)
                itemView.context.startActivity(intent)
            }
        }
    }
}
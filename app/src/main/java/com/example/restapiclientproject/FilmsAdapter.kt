package com.example.restapiclientproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.films_item.view.*

class FilmsAdapter (private val list : ArrayList<FilmResponse>) :
    RecyclerView.Adapter<FilmsAdapter.FilmViewHolder>(){
    inner class FilmViewHolder (itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(filmResponse: FilmResponse){
            with(itemView){
                val cover = "${filmResponse.image}"
                val title = "Title : ${filmResponse.title}"
                val release_date = "Date : ${filmResponse.release_date}"
                val desc = "Description : ${filmResponse.desc}"


                Picasso.get().load(cover).into(ivCover);
                tvTitle.text = title
                tvReleaseDate.text = release_date
                tvDescription.text = desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.films_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(list[position])
    }
}

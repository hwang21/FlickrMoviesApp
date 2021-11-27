package com.flickr.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flickr.movies.R
import com.flickr.movies.model.Movie
import kotlinx.android.synthetic.main.row_layout.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.DataViewHolder>(){

    private var movieList = emptyList<Movie>()

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie) {
            itemView.apply {
                Glide.with(artWorkImage.context)
                    .load(movie.artworkUrl100)
                    .into(artWorkImage)
                trackName.text = movie.trackName
                releaseDate.text = movie.releaseDate.substring(0, 10)
                shortDescription.text = movie.shortDescription
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun setData(movies: List<Movie>) {
        this.movieList = movies
        notifyDataSetChanged()
    }
}
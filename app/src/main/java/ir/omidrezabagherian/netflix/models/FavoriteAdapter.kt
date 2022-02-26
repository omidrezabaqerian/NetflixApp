package ir.omidrezabagherian.netflix.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.omidrezabagherian.netflix.R

class FavoriteAdapter(videos: MutableList<Video>) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteHandler>() {

    var videoItems = videos

    inner class FavoriteHandler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageVideo: ImageView = itemView.findViewById(R.id.imageview_video)
        val titleVideo: TextView = itemView.findViewById(R.id.textview_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHandler {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_favorite_movie, parent, false)
        return FavoriteHandler(view)
    }

    override fun onBindViewHolder(holder: FavoriteHandler, position: Int) {
        val item = videoItems[position]
        holder.imageVideo.setImageBitmap(item.coverIdVideo)
        holder.titleVideo.text = item.titleVideo
    }

    override fun getItemCount() = videoItems.size

}
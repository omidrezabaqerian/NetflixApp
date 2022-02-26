package ir.omidrezabagherian.netflix.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.omidrezabagherian.netflix.fragments.HomeFragment
import ir.omidrezabagherian.netflix.R

class HomeAdapter(videos: MutableList<Video>, var fragment: HomeFragment) :
    RecyclerView.Adapter<HomeAdapter.FavoriteHandler>() {

    private var videoItem = videos
    private lateinit var videoHandler: VideoHandler

    inner class FavoriteHandler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageVideo: ImageView = itemView.findViewById(R.id.imageview_video)
        val titleVideo: TextView = itemView.findViewById(R.id.textview_title)
        val likeVideo: ImageView = itemView.findViewById(R.id.imageview_like)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHandler {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_home_movie, parent, false)
        return FavoriteHandler(view)
    }

    override fun getItemCount() = videoItem.size

    override fun onBindViewHolder(holder: FavoriteHandler, position: Int) {
        val item = videoItem[position]
        if (item.favoriteStatus == Favorite.FAVORITE){
            holder.likeVideo.setImageResource(R.drawable.ic_baseline_favorite_on)
        }
        videoHandler = VideoHandler(fragment)
        holder.titleVideo.text = item.titleVideo
        holder.imageVideo.setImageBitmap(item.coverIdVideo)
        holder.likeVideo.setOnClickListener { result ->
            updateFavoriteState(position,result as ImageView)
        }
    }

    private fun ImageView.changeFavoriteStatus(favorite: Favorite) {
        if (favorite == Favorite.FAVORITE) this.setImageResource(R.drawable.ic_baseline_favorite_on)
        else this.setImageResource(R.drawable.ic_baseline_favorite_off)
    }

    private fun updateFavoriteState(videoId: Int, btn: ImageView) {
        val favorite = videoHandler.changeFavoriteStatus(videoId)
        btn.changeFavoriteStatus(favorite)
    }


}
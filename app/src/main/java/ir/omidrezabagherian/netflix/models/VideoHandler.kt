package ir.omidrezabagherian.netflix.models

import android.graphics.Bitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class VideoHandler(fragment: Fragment) {
    private val dataVideoHolder: DataVideoHolder by fragment.activityViewModels()

    fun addVideo(titleVideo: String, favoriteStatus: Favorite, coverIdVideo: Bitmap?) {
        dataVideoHolder.movieList.add(
            Video(
                dataVideoHolder.idVideo,
                titleVideo,
                favoriteStatus,
                coverIdVideo
            )
        )
        dataVideoHolder.idVideo = dataVideoHolder.idVideo + 1
    }

    private fun getVideoWithItem(idVideo: Int): Video {
        return dataVideoHolder.movieList.filter { movie -> movie.idVideo == idVideo }[0]
    }

    private fun setFavorite(idVideo: Int, favoriteStatus: Favorite) {
        getVideoWithItem(idVideo).favoriteStatus = favoriteStatus
    }

    fun changeFavoriteStatus(idVideo: Int): Favorite {
        return if (getVideoWithItem(idVideo).favoriteStatus == Favorite.NO_FAVORITE) {
            setFavorite(idVideo, Favorite.FAVORITE)
            Favorite.FAVORITE
        } else {
            setFavorite(idVideo, Favorite.NO_FAVORITE)
            Favorite.NO_FAVORITE
        }
    }

    fun getFavorites(): MutableList<Video> {
        return dataVideoHolder.movieList.filter { result -> result.favoriteStatus == Favorite.FAVORITE }
                as MutableList<Video>
    }

    fun getAllVideos(): MutableList<Video> {
        return dataVideoHolder.movieList
    }

}
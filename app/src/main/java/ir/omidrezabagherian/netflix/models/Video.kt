package ir.omidrezabagherian.netflix.models

import android.graphics.Bitmap

class Video() {

    var idVideo: Int = 0
    var titleVideo: String = "No text"
    var favoriteStatus: Favorite = Favorite.NO_FAVORITE
    var coverIdVideo: Bitmap? = null

    constructor(
        idVideo: Int,
        titleVideo: String,
        favoriteStatus: Favorite,
        coverIdVideo: Bitmap?
    ) : this() {
        this.idVideo = idVideo
        this.titleVideo = titleVideo
        this.favoriteStatus = favoriteStatus
        this.coverIdVideo = coverIdVideo
    }

    override fun toString(): String {
        return "Movie(idVideo=$idVideo,titleVideo=$titleVideo,favoriteStatus=$favoriteStatus,coverIdVideo=$coverIdVideo)"
    }

}
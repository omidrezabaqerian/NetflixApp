package ir.omidrezabagherian.netflix.models

import androidx.lifecycle.ViewModel

class DataVideoHolder : ViewModel() {
    var idVideo: Int = 0
    var movieList = mutableListOf<Video>()
}
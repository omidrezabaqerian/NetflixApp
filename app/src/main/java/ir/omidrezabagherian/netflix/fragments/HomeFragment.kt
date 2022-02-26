package ir.omidrezabagherian.netflix.fragments

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import ir.omidrezabagherian.netflix.R
import ir.omidrezabagherian.netflix.databinding.FragmentHomeBinding
import ir.omidrezabagherian.netflix.models.Favorite
import ir.omidrezabagherian.netflix.models.HomeAdapter
import ir.omidrezabagherian.netflix.models.VideoHandler

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeBinding: FragmentHomeBinding
    lateinit var videoHandler: VideoHandler
    private var recyclerViewIsEnable = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding = FragmentHomeBinding.bind(requireView())
        videoHandler = VideoHandler(this)
        addItemToRecyclerView(this.requireContext())
    }

    private fun addItemToRecyclerView(context: Context) {
        val videoImage1 =
            context.resources.getDrawable(R.drawable.black_widow, null) as BitmapDrawable
        val videoImage2 =
            context.resources.getDrawable(R.drawable.breaking_bad, null) as BitmapDrawable
        val videoImage3 =
            context.resources.getDrawable(R.drawable.captain_america, null) as BitmapDrawable
        val videoImage4 =
            context.resources.getDrawable(R.drawable.deadpool1, null) as BitmapDrawable
        val videoImage5 =
            context.resources.getDrawable(R.drawable.deadpool2, null) as BitmapDrawable
        val videoImage6 = context.resources.getDrawable(R.drawable.eternals, null) as BitmapDrawable
        val videoImage7 = context.resources.getDrawable(R.drawable.free_guy, null) as BitmapDrawable
        val videoImage8 = context.resources.getDrawable(R.drawable.friends, null) as BitmapDrawable
        val videoImage9 =
            context.resources.getDrawable(R.drawable.game_of_thrones, null) as BitmapDrawable
        val videoImage10 =
            context.resources.getDrawable(R.drawable.halloween_kills, null) as BitmapDrawable
        val videoImage11 =
            context.resources.getDrawable(R.drawable.iron_man, null) as BitmapDrawable
        val videoImage12 = context.resources.getDrawable(R.drawable.lucifer, null) as BitmapDrawable
        val videoImage13 = context.resources.getDrawable(R.drawable.mad_max, null) as BitmapDrawable
        val videoImage14 = context.resources.getDrawable(R.drawable.matrix, null) as BitmapDrawable
        val videoImage15 =
            context.resources.getDrawable(R.drawable.red_notice, null) as BitmapDrawable
        val videoImage16 =
            context.resources.getDrawable(R.drawable.shang_chi, null) as BitmapDrawable
        val videoImage17 =
            context.resources.getDrawable(R.drawable.spider_man_no_way_home, null) as BitmapDrawable
        val videoImage18 =
            context.resources.getDrawable(R.drawable.suicide_squad1, null) as BitmapDrawable
        val videoImage19 =
            context.resources.getDrawable(R.drawable.suicide_squad2, null) as BitmapDrawable
        val videoImage20 = context.resources.getDrawable(R.drawable.venom, null) as BitmapDrawable
        val videoImage21 = context.resources.getDrawable(R.drawable.vikings, null) as BitmapDrawable

        if (!recyclerViewIsEnable) {
            videoHandler.addVideo("Black Widow", Favorite.NO_FAVORITE, videoImage1.bitmap)
            videoHandler.addVideo("Breaking Bad", Favorite.NO_FAVORITE, videoImage2.bitmap)
            videoHandler.addVideo("Captain America", Favorite.NO_FAVORITE, videoImage3.bitmap)
            videoHandler.addVideo("Deadpool 1", Favorite.NO_FAVORITE, videoImage4.bitmap)
            videoHandler.addVideo("Deadpool 2", Favorite.NO_FAVORITE, videoImage5.bitmap)
            videoHandler.addVideo("Eternals", Favorite.NO_FAVORITE, videoImage6.bitmap)
            videoHandler.addVideo("Free Widow", Favorite.NO_FAVORITE, videoImage7.bitmap)
            videoHandler.addVideo("Friends", Favorite.NO_FAVORITE, videoImage8.bitmap)
            videoHandler.addVideo("Game Of Thrones", Favorite.NO_FAVORITE, videoImage9.bitmap)
            videoHandler.addVideo("Halloween Kills", Favorite.NO_FAVORITE, videoImage10.bitmap)
            videoHandler.addVideo("Iron Man", Favorite.NO_FAVORITE, videoImage11.bitmap)
            videoHandler.addVideo("Lucifer", Favorite.NO_FAVORITE, videoImage12.bitmap)
            videoHandler.addVideo("Mad Max", Favorite.NO_FAVORITE, videoImage13.bitmap)
            videoHandler.addVideo("Black Widow", Favorite.NO_FAVORITE, videoImage14.bitmap)
            videoHandler.addVideo("Red Notice", Favorite.NO_FAVORITE, videoImage15.bitmap)
            videoHandler.addVideo("Shang Chi", Favorite.NO_FAVORITE, videoImage16.bitmap)
            videoHandler.addVideo(
                "Spider-Man No Way Home",
                Favorite.NO_FAVORITE,
                videoImage17.bitmap
            )
            videoHandler.addVideo("Suicide Squad 1", Favorite.NO_FAVORITE, videoImage18.bitmap)
            videoHandler.addVideo("Suicide Squad 2", Favorite.NO_FAVORITE, videoImage19.bitmap)
            videoHandler.addVideo("Venom", Favorite.NO_FAVORITE, videoImage20.bitmap)
            videoHandler.addVideo("Vikings", Favorite.NO_FAVORITE, videoImage21.bitmap)

        }
    }

    private fun setVideos() {
        recyclerViewIsEnable = true

        homeBinding.recyclerviewHome.adapter = HomeAdapter(videoHandler.getAllVideos(), this)
        homeBinding.recyclerviewHome.layoutManager = GridLayoutManager(requireContext(), 3)
    }

    override fun onResume() {
        super.onResume()
        setVideos()
    }
}
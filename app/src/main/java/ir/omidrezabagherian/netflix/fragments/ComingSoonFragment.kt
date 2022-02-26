package ir.omidrezabagherian.netflix.fragments

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ir.omidrezabagherian.netflix.R
import ir.omidrezabagherian.netflix.databinding.FragmentComingSoonBinding
import ir.omidrezabagherian.netflix.models.ComingSoonAdapter
import ir.omidrezabagherian.netflix.models.ComingSoonVideo

class ComingSoonFragment : Fragment(R.layout.fragment_coming_soon) {

    private lateinit var bindingComingSoon: FragmentComingSoonBinding
    private lateinit var videoAdapter: ComingSoonAdapter
    private var videoList = mutableListOf<ComingSoonVideo>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingComingSoon = FragmentComingSoonBinding.bind(view)

        bindingComingSoon.recyclerviewComingSoon.layoutManager =
            LinearLayoutManager(requireContext())
        videoAdapter = ComingSoonAdapter(this)

        addItemToRecyclerView(requireContext())

        videoAdapter.setDataList(videoList)

        bindingComingSoon.recyclerviewComingSoon.adapter = videoAdapter

        super.onViewCreated(view, savedInstanceState)
    }

    private fun addItemToRecyclerView(context: Context) {
        val videoImage1 =
            context.resources.getDrawable(R.drawable.black_widow, null) as BitmapDrawable
        val videoImage2 =
            context.resources.getDrawable(R.drawable.breaking_bad, null) as BitmapDrawable
        val videoImage3 =
            context.resources.getDrawable(R.drawable.captain_america, null) as BitmapDrawable

        videoList.add(
            ComingSoonVideo(
                videoImage1.bitmap,
                "BlackWidow",
                "Description Video Black Widow"
            )
        )
        videoList.add(
            ComingSoonVideo(
                videoImage2.bitmap,
                "Breaking Bad",
                "Description Video Breaking Bad"
            )
        )
        videoList.add(
            ComingSoonVideo(
                videoImage3.bitmap,
                "Captain America",
                "Description Video Captain America"
            )
        )

        videoAdapter.setDataList(videoList)

    }

}
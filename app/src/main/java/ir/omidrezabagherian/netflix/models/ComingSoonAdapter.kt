package ir.omidrezabagherian.netflix.models

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ir.omidrezabagherian.netflix.R

class ComingSoonAdapter(
    private val fragment: Fragment
) :
    RecyclerView.Adapter<ComingSoonAdapter.ViewHolder>() {
    private var dataList = emptyList<ComingSoonVideo>()

    internal fun setDataList(dataList: List<ComingSoonVideo>) {
        this.dataList = dataList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageview_video)
        val title: TextView = itemView.findViewById(R.id.textview_title)
        val description: TextView = itemView.findViewById(R.id.textview_description)
        val share: ImageView = itemView.findViewById(R.id.imageview_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_coming_soon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.image.setImageBitmap(data.coverIdVideo)
        holder.title.text = data.titleVideo
        holder.description.text = data.descriptionVideo
        holder.share.setOnClickListener {
            val textShare: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Video Title: ${data.titleVideo}\nVideo Description: ${data.descriptionVideo}"
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(textShare, null)

            fragment.startActivity(shareIntent)
        }
    }

    override fun getItemCount() = dataList.size

}
package com.example.facebookclone.adapter

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookclone.R
import com.example.facebookclone.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var items: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position)) TYPE_ITEM_HEAD else TYPE_ITEM_STORY
    }

    fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_story_header, parent, false)
            return HeaderViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is HeaderViewHolder){
            var iv_profile = holder.iv_profile

            iv_profile.setImageResource(story.profile)
        }

        if (holder is StoryViewHolder) {
            var iv_background = holder.iv_background
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

            iv_background.setImageResource(story.profile)
            iv_profile.setImageResource(story.profile)
            tv_fullname.text = story.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_background: ShapeableImageView
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_background = view.findViewById(R.id.iv_background)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullName)
        }
    }

    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
        }
    }
}
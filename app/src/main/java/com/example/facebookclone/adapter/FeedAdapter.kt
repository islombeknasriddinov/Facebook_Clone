package com.example.facebookclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.facebookclone.R
import com.example.facebookclone.activity.MindActivity
import com.example.facebookclone.model.Feed
import com.example.facebookclone.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1
    private val TYPE_ITEM_POST = 2
    private val TYPE_ITEM_LINK = 3

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]

        if (feed.isHeader) {
            return TYPE_ITEM_HEAD
        } else if (feed.stories.size > 0) {
            return TYPE_ITEM_STORY
        }
        return TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEAD) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_header, parent, false)
            return HeadViewHolder(context,view)
        }
        if (viewType == TYPE_ITEM_STORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(context,view)
        }
        if (viewType == TYPE_ITEM_LINK){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_link_view, parent, false)
            return LinkViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent,false)
        return PostViewHolder(view)
    }

    fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(context,stories)
        recyclerView.adapter = adapter
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeadViewHolder){
            holder.mind.setOnClickListener {
                openMindActivity()
            }
        }

        if (holder is LinkViewHolder){
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            Glide.with(context).load(feed.link!!.photo).fitCenter().into(holder.iv_photo)
            var tv_title = holder.tv_title
            var tv_description = holder.tv_description

            iv_profile.setImageResource(feed.link!!.profile)
            tv_fullname.text = feed.link!!.fullname
            tv_title.text = feed.link!!.title
            tv_description.text = feed.link!!.description

        }

        if (holder is StoryViewHolder){

            holder.apply {
                if (adapter == null){
                    var recyclerView = holder.recyclerView
                    adapter = StoryAdapter(context,feed.stories)
                    recyclerView.adapter = adapter
                }
            }



        }

        if (holder is PostViewHolder){
            var iv_profile = holder.iv_profile
            Glide.with(context).load(feed.post?.photo).fitCenter().into(holder.iv_photo)
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.post!!.profile)
            tv_fullname.text = feed.post!!.fullname

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class LinkViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_profile: ImageView
        var tv_fullname: TextView
        var iv_photo: ImageView
        var tv_title: TextView
        var tv_description: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname2)
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_title = view.findViewById(R.id.tv_title)
            tv_description = view.findViewById(R.id.tv_description)
        }

    }

    class HeadViewHolder(context: Context, view: View): RecyclerView.ViewHolder(view){
        val mind : TextView = view.findViewById(R.id.tv_mind)
    }

    class StoryViewHolder(context: Context, view: View): RecyclerView.ViewHolder(view){
        val recyclerView: RecyclerView

        var adapter: StoryAdapter? = null

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            recyclerView.setLayoutManager(manager)
        }

    }

    class PostViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView
        var iv_photo: ImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_fullname = view.findViewById(R.id.tv_fullname1)
        }

    }

    private fun openMindActivity() {
            val intent = Intent(context, MindActivity::class.java)
            context.startActivity(intent)
    }

}
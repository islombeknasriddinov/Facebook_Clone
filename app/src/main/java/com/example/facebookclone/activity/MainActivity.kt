package com.example.facebookclone.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebookclone.R
import com.example.facebookclone.adapter.FeedAdapter
import com.example.facebookclone.model.Feed
import com.example.facebookclone.model.Post
import com.example.facebookclone.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }


    private fun initView() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllFeeds())
    }

    private fun getAllFeeds(): ArrayList<Feed> {



        val stories: ArrayList<Story> = ArrayList<Story>()

        //Header
        stories.add(Story(R.drawable.profile))
        //story
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))
        stories.add(Story(R.drawable.profile,"Islombek"))



        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        //Head
        feeds.add(Feed())
        //Story
        feeds.add(Feed(stories))
        //Post
        var str: String =
            "https://images.unsplash.com/photo-1644910595529-1075df35cff5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"
        var str1: String =
            "https://images.unsplash.com/photo-1644869314419-44700548bd92?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        var str2: String =
            "https://images.unsplash.com/photo-1644091082395-5b8b8e1555e2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=327&q=80"
        var str3: String =
            "https://images.unsplash.com/photo-1644164935217-46328ef58943?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
        var str4: String =
            "https://images.unsplash.com/photo-1643277227040-1919439d29c2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=436&q=80"
        var str6: String =
            "https://images.unsplash.com/photo-1641096179465-52e208f6dc49?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=435&q=80"
        var str7: String =
            "https://images.unsplash.com/photo-1644463589256-02679b9c0767?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80"
        var str8: String =
            "https://images.unsplash.com/photo-1644447295446-19b7e712a895?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        var str9: String =
            "https://images.unsplash.com/photo-1644784960532-7a3d7195e26a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=465&q=80"
        var str10: String =
            "https://images.unsplash.com/photo-1617886337523-4dcbb15230a2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
        var str11: String =
            "https://images.unsplash.com/photo-1644249885405-f93979865ece?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1031&q=80"
        var str12: String =
            "https://images.unsplash.com/photo-1601068079900-7e1e18c896b7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        var str13: String =
            "https://images.unsplash.com/photo-1640957507202-6e5ad7cd3365?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=425&q=80"
        var str14: String =
            "https://images.unsplash.com/photo-1643937583754-ee8aa3d5ccd2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"

        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str14)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str10)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str9)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str11)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str7)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str2)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str8)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str3)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str6)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str13)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str4)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str12)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str1)))
        feeds.add(Feed(Post(R.drawable.profile, "Islombek Nasriddinov", str10)))


        return feeds
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView!!.adapter = adapter
    }


}
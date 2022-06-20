package com.example.facebookclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.facebookclone.R

class MindActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mind)
        initView()
    }

    private fun initView() {
        val back = findViewById<TextView>(R.id.btn_back)
        back.setOnClickListener {
            finish()
        }

        val btn_post = findViewById<Button>(R.id.btn_post)
        btn_post.setOnClickListener{

        }
    }
}
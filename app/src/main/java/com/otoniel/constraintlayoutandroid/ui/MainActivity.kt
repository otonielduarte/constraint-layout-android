package com.otoniel.constraintlayoutandroid.ui

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.otoniel.constraintlayoutandroid.adapter.MyAdapter
import com.otoniel.constraintlayoutandroid.R

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: ListView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.appbar_name)

        containerView = findViewById(R.id.containerListView)
        containerView.adapter = MyAdapter(this)
    }
}
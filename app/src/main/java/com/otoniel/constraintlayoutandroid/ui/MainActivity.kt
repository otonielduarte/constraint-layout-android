package com.otoniel.constraintlayoutandroid.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.otoniel.constraintlayoutandroid.adapter.MyAdapter
import com.otoniel.constraintlayoutandroid.R
import com.otoniel.constraintlayoutandroid.data.PlacesDAO
import com.otoniel.constraintlayoutandroid.model.Model

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: ListView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.appbar_name)

        containerView = findViewById(R.id.containerListView)
        handleAdapter()
    }

    private fun handleAdapter() {
        var list = PlacesDAO().list()
        containerView.adapter = MyAdapter(this, list)
        containerView.setOnItemClickListener { _, _, position, _ -> navigateDoDetails(position) }
    }

    private fun navigateDoDetails(position: Int) {
        val clicked = containerView.adapter.getItem(position) as Model
        val intent = Intent(this@MainActivity, PackageDetailsActivity::class.java)
        intent.putExtra("packageClicked", clicked)
        startActivity(intent)
    }
}
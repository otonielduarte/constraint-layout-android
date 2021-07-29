package com.otoniel.constraintlayoutandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.otoniel.constraintlayoutandroid.R
import com.otoniel.constraintlayoutandroid.model.Model
import com.otoniel.constraintlayoutandroid.utils.ResourcesUtil
import kotlinx.android.synthetic.main.activity_order_resume.*


class OrderResumeActivity : AppCompatActivity() {
    private lateinit var packageClicked: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_resume)
        handleActionBar()
        initValues()
    }

    private fun initValues() {
        packageClicked = intent.getSerializableExtra("packageClicked") as Model
        bindingFields()
    }

    private fun handleActionBar() {
        setTitle(R.string.appbar_order_resume)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun bindingFields() {
        packageImage.setImageDrawable(ResourcesUtil.getDrawable(this, packageClicked.image))
        packageCity.text = packageClicked.city
        packagePrice.text = packageClicked.getFormattedPrice()
        packageDate.text = packageClicked.getDatePeriod()
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_TASK_ON_HOME
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
        return true
    }
}
package com.otoniel.constraintlayoutandroid.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.otoniel.constraintlayoutandroid.R
import com.otoniel.constraintlayoutandroid.model.Model
import com.otoniel.constraintlayoutandroid.utils.ResourcesUtil
import kotlinx.android.synthetic.main.package_details.*

class PackageDetailsActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var packageClicked: Model;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_details)
        handleActionBar()
        initValues()
    }

    private fun initValues() {
        packageClicked = intent.getSerializableExtra("packageClicked") as Model
        btnPayments.setOnClickListener(this)
        bindingValues()
    }

    private fun handleActionBar() {
        setTitle(R.string.appbar_details_package)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun bindingValues() {
        packageImage.setImageDrawable(ResourcesUtil.getDrawable(this, packageClicked.image))
        packageCity.text = packageClicked.city
        packageDays.text = packageClicked.getDaysString()
        packagePrice.text = packageClicked.getFormattedPrice()
        packageDate.text = packageClicked.getDatePeriod()
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@PackageDetailsActivity, PaymentActivity::class.java)
        intent.putExtra("packageClicked", packageClicked)
        startActivity(intent)
        setResult(Activity.RESULT_OK)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
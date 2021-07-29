package com.otoniel.constraintlayoutandroid.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.otoniel.constraintlayoutandroid.R
import com.otoniel.constraintlayoutandroid.model.Model
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var packageClicked: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        handleActionBar()
        initValues()
    }

    private fun initValues() {
        btnMakePayment.setOnClickListener(this)
        packageClicked = intent.getSerializableExtra("packageClicked") as Model
        paymentValue.text = packageClicked.getFormattedPrice()
    }

    private fun handleActionBar() {
        setTitle(R.string.appbar_payment)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@PaymentActivity, OrderResumeActivity::class.java)
        intent.putExtra("packageClicked", packageClicked)
        startActivity(intent)
        setResult(Activity.RESULT_OK)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
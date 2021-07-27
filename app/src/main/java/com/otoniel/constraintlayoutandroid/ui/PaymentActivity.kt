package com.otoniel.constraintlayoutandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.otoniel.constraintlayoutandroid.model.Model

class PaymentActivity : AppCompatActivity() {
    private lateinit var packageClicked: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        packageClicked = intent.getSerializableExtra("packageClicked") as Model

    }
}
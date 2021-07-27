package com.otoniel.constraintlayoutandroid.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.otoniel.constraintlayoutandroid.R
import com.otoniel.constraintlayoutandroid.data.PlacesDAO
import com.otoniel.constraintlayoutandroid.model.Model
import com.otoniel.constraintlayoutandroid.ui.PackageDetailsActivity
import com.otoniel.constraintlayoutandroid.utils.CurrencyFormat
import com.otoniel.constraintlayoutandroid.utils.ResourcesUtil



class MyAdapter(private var context: Context) : BaseAdapter() {
    private var places: List<Model> = PlacesDAO().lista()

    override fun getCount(): Int {
        return places.size
    }

    override fun getItem(position: Int): Model {
        return places[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflated = getView(parent)
        val model: Model = getItem(position)
        bindFields(inflated, model)
        inflated.setOnClickListener { navigateDoDetails(model) }
        return inflated
    }

    private fun bindFields(inflated: View, model: Model) {
        val image = inflated.findViewById<ImageView>(R.id.imageItem)
        val city = inflated.findViewById<TextView>(R.id.item_city)
        val days = inflated.findViewById<TextView>(R.id.item_days)
        val price = inflated.findViewById<TextView>(R.id.item_price)

        image.setImageDrawable(ResourcesUtil.getDrawable(context, model.image))
        city.text = model.city
        days.text = model.getDaysString()
        price.text = model.getFormattedPrice()
    }

    private fun getView(parent: ViewGroup?): View {
        return LayoutInflater
            .from(context)
            .inflate(R.layout.item, parent, false);
    }

    private fun navigateDoDetails(clicked: Model) {
        val intent = Intent(context, PackageDetailsActivity::class.java)
        intent.putExtra("packageClicked", clicked)
        ContextCompat.startActivity(context, intent, null)
    }
}
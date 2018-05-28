package com.dariomartin.kotlinexample.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dariomartin.kotlinexample.R
import com.dariomartin.kotlinexample.domain.model.Forecast
import com.dariomartin.kotlinexample.domain.model.ForecastList
import com.dariomartin.kotlinexample.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by megamedia on 24/5/18.
 */


class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(val view: View, private val itemClick: (Forecast)->Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.dateText.text = date
                itemView.descriptionText.text = description
                itemView.maxTemperatureText.text = "${high}º"
                itemView.minTemperatureText.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }
}
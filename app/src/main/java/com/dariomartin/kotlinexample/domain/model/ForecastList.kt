package com.dariomartin.kotlinexample.domain.model

/**
 * Created by megamedia on 24/5/18.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]

}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)
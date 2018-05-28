package com.dariomartin.kotlinexample.adapters

import com.dariomartin.kotlinexample.domain.model.Forecast

/**
 * Created by megamedia on 28/5/18.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}
package com.dariomartin.kotlinexample.domain.commands

import com.dariomartin.kotlinexample.Request
import com.dariomartin.kotlinexample.domain.Command
import com.dariomartin.kotlinexample.domain.mappers.ForecastDataMapper
import com.dariomartin.kotlinexample.domain.model.ForecastList

/**
 * Created by megamedia on 24/5/18.
 */
class RequestForecastCommand(private val zipcode:String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = Request(zipcode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}
package com.dariomartin.kotlinexample.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.dariomartin.kotlinexample.R
import com.dariomartin.kotlinexample.adapters.ForecastListAdapter
import com.dariomartin.kotlinexample.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show();
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = listOf(
                "Mon 6/23 - Sunny - 31/17",
                "Tue 6/24 - Foggy - 21/8",
                "Wed 6/25 - Cloudy - 18/11",
                "Thu 6/26 - Rainy - 20/16",
                "Fri 6/27 - Sunny - 31/28",
                "Sat 6/28 - Rainy - 21/9",
                "Sun 6/29 - Coudy - 15/20"
        )

        val zipcode = "94043"

        forecast_list.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand(zipcode).execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result) { toast(it.date) }
            }
        }

    }
}

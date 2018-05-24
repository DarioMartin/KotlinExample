package com.dariomartin.kotlinexample.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dariomartin.kotlinexample.R
import com.dariomartin.kotlinexample.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*

val ViewGroup.childViews: List<View>
    get() = (0 until childCount).map { getChildAt(it) }

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

        forecast_list.layoutManager = LinearLayoutManager(this)
        forecast_list.adapter = ForecastListAdapter(list)



        toast("Toast de prueba")

        forecast_list.childViews


    }
}

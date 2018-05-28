package com.dariomartin.kotlinexample

import android.app.Application
import com.dariomartin.kotlinexample.utils.DelegatesExt

/**
 * Created by megamedia on 28/5/18.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

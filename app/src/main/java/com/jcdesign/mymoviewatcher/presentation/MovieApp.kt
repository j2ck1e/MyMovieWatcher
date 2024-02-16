package com.jcdesign.mymoviewatcher.presentation

import android.app.Application
import com.jcdesign.mymoviewatcher.di.DaggerApplicationComponent

class MovieApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}
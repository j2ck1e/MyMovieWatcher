package com.jcdesign.mymoviewatcher.di

import android.app.Application
import com.jcdesign.mymoviewatcher.presentation.MovieItemFragment
import com.jcdesign.mymoviewatcher.presentation.SearchMovieFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        MovieModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: MovieItemFragment)

    fun inject(fragment: SearchMovieFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}
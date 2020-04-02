package com.example.accenturerestapidemo.di

import com.example.accenturerestapidemo.view.MainActivity
import dagger.Component


@Component
interface MyAppComponent {
    fun inject(mainActivity: MainActivity)
}
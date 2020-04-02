package com.example.wiproassignmentproject.di

import androidx.lifecycle.ViewModelProvider

import com.example.wiproassignmentproject.factory.MyViewModelfactory
import dagger.Binds
import dagger.Module

@Module
abstract class MyFactoryViewModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelfactory: MyViewModelfactory):ViewModelProvider.Factory
}
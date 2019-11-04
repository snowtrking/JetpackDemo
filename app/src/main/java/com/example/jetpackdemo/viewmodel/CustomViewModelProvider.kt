package com.example.jetpackdemo.viewmodel

import android.content.Context
import com.example.jetpackdemo.db.RepositoryProvider
import com.example.jetpackdemo.db.repository.ShoeRepository
import com.example.jetpackdemo.viewmodel.factory.ShoeModelFactory

object CustomViewModelProvider {
    fun providerShoeModel(context: Context): ShoeModelFactory {
        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        return ShoeModelFactory(repository)
    }
}
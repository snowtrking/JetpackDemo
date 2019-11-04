package com.example.jetpackdemo.db

import android.content.Context
import com.example.jetpackdemo.db.repository.ShoeRepository

object RepositoryProvider {
    /**
     * 得到用户仓库
     */


    /**
     * 得到鞋的本地仓库
     */
    fun providerShoeRepository(context: Context):ShoeRepository{
        return ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())
    }

    /**
     * 得到收藏记录的仓库
     */
}
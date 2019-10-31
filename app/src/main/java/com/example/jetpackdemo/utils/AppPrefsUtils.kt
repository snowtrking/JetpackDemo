package com.example.jetpackdemo.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.jetpackdemo.common.BaseApplication
import com.example.jetpackdemo.common.BaseConstant

object AppPrefsUtils {
    private var sp: SharedPreferences =
        BaseApplication.context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
    private var ed: SharedPreferences.Editor

    init {
        ed = sp.edit()
    }

}
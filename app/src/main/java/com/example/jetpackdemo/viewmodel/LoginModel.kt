package com.example.jetpackdemo.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.ui.activity.MainActivity

class LoginModel constructor(name: String, pwd: String, context: Context) {
    val n = ObservableField<String>(name)
    val p = ObservableField<String>(pwd)
    var context: Context = context

    fun onNameChanged(s: CharSequence) {
        n.set(s.toString())
    }

    fun onPwdChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        p.set(s.toString())
    }

    fun login() {
        if (n.get().equals(BaseConstant.USER_NAME)
            && p.get().equals(BaseConstant.USER_PWD)
        ) {
            Toast.makeText(context, "账号密码正确", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
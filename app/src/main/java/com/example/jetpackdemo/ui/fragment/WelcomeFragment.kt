package com.example.jetpackdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.jetpackdemo.R
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            val navOption = navOptions {
                anim {
                    enter = R.anim.common_slide_in_right
                    exit = R.anim.common_slide_out_left
                    popEnter = R.anim.common_slide_in_left
                    popExit = R.anim.common_slide_out_left
                }
            }
            val name = AppPrefsUtils.getString(BaseConstant.SP_USER_NAME)
            // Navigation 传递参数
            val bundle = Bundle()
            bundle.putString(BaseConstant.ARGS_NAME, name)
            findNavController().navigate(R.id.login, bundle, navOption)
        }

        btn_register.setOnClickListener {
            // 利用SafeArgs传递参数
            val action=WelcomeFragmentDirections
                .actionWelcomeFragmentToRegister()
                .setEMAIL("1234@qq.com")
            findNavController().navigate(action)
        }
    }
}

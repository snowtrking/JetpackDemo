package com.example.jetpackdemo.ui.fragment.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jetpackdemo.R
import com.example.jetpackdemo.common.BaseConstant
import com.example.jetpackdemo.databinding.FragmentLoginBinding
import com.example.jetpackdemo.ui.activity.MainActivity
import com.example.jetpackdemo.viewmodel.LoginModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        binding.model = LoginModel("", "", context!!)
        binding.activity = activity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        et_account.setText(bundle.getString(BaseConstant.ARGS_NAME))
        btn_login.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }
    }
}

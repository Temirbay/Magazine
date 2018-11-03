package com.example.miras.magazine.auth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miras.magazine.MainActivity
import com.example.miras.magazine.R
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity(), AuthContract.LoginView{

    override val presenter: AuthContract.LoginPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.attachView(this)

        presenter.lastUserEmail()

        bn_login.setOnClickListener {
            presenter.loginUser(tv_email.text.toString(),
                tv_password.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onLoginSuccess() {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setEmail(email: String?) {
        tv_email.setText(email)
    }

}

package com.hamdan.i210724

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun toSignup(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }

    fun toProfile(view: View) {
        val intent = Intent(this,profile::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toReset(view: View) {
        val intent = Intent(this, ResetPasswordActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }

}
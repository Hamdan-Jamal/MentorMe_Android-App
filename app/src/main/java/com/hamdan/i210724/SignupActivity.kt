package com.hamdan.i210724

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun toLogin(view: View) {
        val intent = Intent(this,LoginActivity::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toVerify(view: View) {
        val intent = Intent(this,VerificationActivity::class.java)
        view.context.startActivity(intent)
        finish()

    }
}
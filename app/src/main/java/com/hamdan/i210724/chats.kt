package com.hamdan.i210724

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class chats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)
    }

    fun toSearch(view: View) {
        val intent = Intent(this,LetsFindActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }
    fun toProfile(view: View) {
        val intent = Intent(this,profile::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toAdd(view: View) {
        val intent = Intent(this,AddMentorActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }
    fun toMyProfile(view: View) {
        val intent = Intent(this,MyProfile::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toJohn(view: View) {
        val intent = Intent(this,JohnCooper::class.java)
        view.context.startActivity(intent)
        finish()
    }
}
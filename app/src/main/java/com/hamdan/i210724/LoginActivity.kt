package com.hamdan.i210724

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.hamdan.i210724.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        if (firebaseAuth == null) {
            Toast.makeText(this, "Firebase Authentication is not initialized", Toast.LENGTH_SHORT).show()
            return
        }

    }

    fun toSignup(view: View) {
       val intent = Intent(this, SignupActivity::class.java)
       view.context.startActivity(intent)
        finish()
    }

     fun toProfile(view: View) {
    val email = binding.editTextEmail.text.toString()
    val password = binding.editTextPassword.text.toString()

    if (email.isNotEmpty() && password.isNotEmpty()) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MyProfile::class.java)
                startActivity(intent)
                finish() // Finish LoginActivity after starting MyProfile activity
            } else {
                val exception = task.exception
                if (exception is FirebaseAuthInvalidUserException) {
                    // This exception is thrown if there is no user corresponding to the given email.
                    Toast.makeText(this, "Email address not recognized", Toast.LENGTH_SHORT).show()
                } else if (exception is FirebaseAuthInvalidCredentialsException) {
                    // This exception is thrown if the provided credentials are incorrect.
                    // For example, if the password is wrong.
                    Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
                } else {
                    // Handle other exceptions
                    if (exception != null) {
                        Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    } else {
        Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show()
    }
}


    fun toReset(view: View) {
        val intent = Intent(this, ResetPasswordActivity::class.java)
        view.context.startActivity(intent)
        finish()
    }

}
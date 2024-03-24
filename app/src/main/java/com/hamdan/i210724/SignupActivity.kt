package com.hamdan.i210724

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.hamdan.i210724.databinding.ActivitySignupBinding
import kotlin.time.measureTimedValue

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signup.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val country = binding.editTextCountry.text.toString()
            val phone = binding.editTextPhoneNumber.text.toString()
            val city = binding.editTextCity.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && country.isNotEmpty() && phone.isNotEmpty() && city.isNotEmpty() && password.isNotEmpty())
            {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener()
                {
                    if (it.isSuccessful) {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email or Password not valid", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun toLogin(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        view.context.startActivity(intent)
        finish()

    }

    fun toVerify(view: View) {
        val intent = Intent(this, VerificationActivity::class.java)
        view.context.startActivity(intent)
        finish()

    }
}
package com.example.agdesk

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.agdesk.database.DatabaseHelper
import com.example.agdesk.databinding.ActivityRegisterBinding
import com.example.agdesk.models.UIModels.UserModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fullText = "Already have an account? Login here"
        val spannableString = SpannableString(fullText)

        // Find the index of the word "login"
        val startIndex = fullText.indexOf("Login")
        val endIndex = startIndex + "Login".length
        println("Start Index: $startIndex, End Index: $endIndex")

        if (startIndex >= 0) {
            // Set the color for the word "Register"
            spannableString.setSpan(
                ForegroundColorSpan(
                    ContextCompat.getColor(
                        this,
                        R.color.main
                    )
                ),  // Green color for "Register"
                startIndex,
                endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        // Set default color for other text (if needed)
        binding.tvOrContinue.setTextColor(ContextCompat.getColor(this, R.color.black))

        // Apply the styled text to the TextView
        binding.tvOrContinue.text = spannableString
        dbHelper = DatabaseHelper(this)

        binding.tvOrContinue.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()

            if (validateInput(name, email, password, confirmPassword)) {
                val success = dbHelper.createUser(
                    UserModel(
                        name = name,
                        email = email,
                        password = password
                    )
                )
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun validateInput(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
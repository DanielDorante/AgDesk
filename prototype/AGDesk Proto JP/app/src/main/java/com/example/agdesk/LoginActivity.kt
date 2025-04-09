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
import com.example.agdesk.databinding.ActivityLoginBinding
import com.example.agdesk.models.HelperClass
import com.example.agdesk.models.UserModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var dbHelper: DatabaseHelper
    var checkDetails = false
    var list: List<UserModel> = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fullText = "Don’t have an account? Register here"
        val spannableString = SpannableString(fullText)

        // Find the index of the word "Register"
        val startIndex = fullText.indexOf("Register")
        val endIndex = startIndex + "Register".length
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
        binding.tvRegister.setTextColor(ContextCompat.getColor(this, R.color.black))

        // Apply the styled text to the TextView
        binding.tvRegister.text = spannableString

        dbHelper = DatabaseHelper(this)

        // Handle sign-in button click
        binding.btnSignIn.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                list = dbHelper.getAllUsers()
                for (users in list) {

                    if (email == users.email && password == users.password) {
                        checkDetails = true
                        showMessage("Successfully Login")
                        HelperClass.users = users
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                        break
                    }
                }

                if (!checkDetails) {
                    showMessage("Wrong Credentials...\nPlease check email or password")
                }
            } else {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle register text click
        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
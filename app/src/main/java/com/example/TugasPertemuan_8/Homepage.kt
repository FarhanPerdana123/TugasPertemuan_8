package com.example.TugasPertemuan_8

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.TugasPertemuan_8.R
import com.example.TugasPertemuan_8.databinding.ActivityHomepageBinding

class Homepage : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                val tobebek = Intent(this@Homepage, MainActivity::class.java).apply {
                }
                startActivity(tobebek)
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(RegisterFragment.EXTRA_USERNAME)
        val username2 = intent.getStringExtra(LoginFragment.EXTRA_USERNAME)

        with(binding) {
            userName.text = "$username !"
            btnBad.setOnClickListener {
                Toast.makeText(this@Homepage, "sedih", Toast.LENGTH_SHORT).show()
                true
            }
            btnSmile.setOnClickListener {
                Toast.makeText(this@Homepage, "senang", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
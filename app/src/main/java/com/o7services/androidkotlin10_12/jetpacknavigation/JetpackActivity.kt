package com.o7services.androidkotlin10_12.jetpacknavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.o7services.androidkotlin10_12.R
import com.o7services.androidkotlin10_12.databinding.ActivityFragmentBaseBinding
import com.o7services.androidkotlin10_12.databinding.ActivityJetpackBinding

class JetpackActivity : AppCompatActivity() {
    lateinit var binding: ActivityJetpackBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityJetpackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController=findNavController(R.id.controller)
    }
}
package com.o7services.androidkotlin10_12

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitIntentActivity : AppCompatActivity() {
    var btnLink:Button?=null
    var btnCall:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLink=findViewById(R.id.btnLink)
        btnCall=findViewById(R.id.btnCall)
        btnLink?.setOnClickListener {
            var intent= Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://o7services.com/"))
            startActivity(intent)
        }
        btnCall?.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:9041520604"))
            startActivity(intent)
        }
    }


}
package com.o7services.androidkotlin10_12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.androidkotlin10_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var btn: Button? = null
    var edt: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // initialising the var with findviewbyid
        btn = findViewById(R.id.btnNext)
        edt = findViewById(R.id.edtValue)
        //clicklistner
        btn?.setOnClickListener {
            //Validation
            if (edt?.text.toString().isNullOrEmpty()) {
                //error enabling
                edt?.error = "Value Required"
                Toast.makeText(this, "Enter a value", Toast.LENGTH_SHORT).show()
            } else {
                //navigation from one screen to another using Explicit Intent
                var intent = Intent(this, RelativeActivity::class.java)
                startActivity(intent)
            }
        }

        binding.btnALERTDialog.setOnClickListener {
           startActivity(Intent(this,AlertDialogActivity::class.java))
        }
    }
}
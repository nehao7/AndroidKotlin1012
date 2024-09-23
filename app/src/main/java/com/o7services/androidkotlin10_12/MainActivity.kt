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
import com.o7services.androidkotlin10_12.jetpacknavigation.JetpackActivity
import com.o7services.androidkotlin10_12.listpackage.ListActivity
import com.o7services.androidkotlin10_12.listpackage.ListBaseAdapterActivity
import com.o7services.androidkotlin10_12.recyclerpackage.RecyclerActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var btn: Button? = null
    var edt: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show()

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
        binding.btnSetText.setOnClickListener {
            if (binding.edtAddvalue.text.isNullOrEmpty()) {
                Toast.makeText(this, "Enter a value", Toast.LENGTH_SHORT).show()

            } else {
                binding.tvsetValue.text = binding.edtAddvalue.text.toString()
                var value = binding.tvsetValue.text.toString()
                var intent = Intent(this, GetDataActivity::class.java)
                intent.putExtra("key", value)
                startActivity(intent)
            }
        }

        binding.btnALERTDialog.setOnClickListener {
            startActivity(Intent(this, AlertDialogActivity::class.java))
        }
        binding.btnImplicitIntent.setOnClickListener {
            startActivity(Intent(this, ImplicitIntentActivity::class.java))
        }
        binding.btnFragmentActivity.setOnClickListener {
            startActivity(Intent(this, FragmentBaseActivity::class.java))
        }
        binding.btnJetpackActivity.setOnClickListener {
            startActivity(Intent(this, JetpackActivity::class.java))
        }
        binding.btnListActivity.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.btnListAdapterActivity.setOnClickListener {
            startActivity(Intent(this, ListBaseAdapterActivity::class.java))
        }
        binding.btnRecyclerActivity.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "OnReStart", Toast.LENGTH_SHORT).show()


    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()


    }
}
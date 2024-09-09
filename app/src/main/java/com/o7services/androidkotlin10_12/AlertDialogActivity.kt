package com.o7services.androidkotlin10_12

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.o7services.androidkotlin10_12.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button1.setOnClickListener {
            Toast.makeText(this, "this is my toast", Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener {
            Snackbar.make(it, "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Undo", {
                    Toast.makeText(
                        this, "Toast is invoked from snackbar",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                .show()
        }

        binding.btnDialog.setOnClickListener {
//          var dialog=  AlertDialog.Builder(this)
//            dialog.setTitle("This is my alert Dialog")
//            dialog.setPositiveButton("Yes"){_,_->
//                Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
//            }
//            dialog.setNegativeButton("No"){_,_->
//                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
//            }
//            dialog.setCancelable(false)
//            dialog.show()

            AlertDialog.Builder(this).apply {
            setTitle("Do you want to exit this screen")
            setPositiveButton("Yes"){_,_->
                finish()
                Toast.makeText(this@AlertDialogActivity, "Positive", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("No"){_,_->
                Toast.makeText(this@AlertDialogActivity, "Negative", Toast.LENGTH_SHORT).show()
            }
            setCancelable(false)
            show()
            }
        }

    }
}
package com.o7services.androidkotlin10_12.listpackage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.androidkotlin10_12.R
import com.o7services.androidkotlin10_12.databinding.ActivityListBaseAdapterBinding

class ListBaseAdapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBaseAdapterBinding
    var list = arrayListOf("c", "C++", "Java")
    var studentList = arrayListOf<Student>()
    var listAdapter=ListAdapter(studentList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityListBaseAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        studentList.add(Student(1,"Rohan","C"))
        studentList.add(Student(2,"Mohan","C++"))
        studentList.add(Student(3,"sahil","Java"))
        binding.listiewnew.adapter=listAdapter
    }
}
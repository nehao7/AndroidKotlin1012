package com.o7services.androidkotlin10_12.recyclerpackage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.o7services.androidkotlin10_12.R
import com.o7services.androidkotlin10_12.databinding.ActivityRecyclerBinding
import com.o7services.androidkotlin10_12.listpackage.Student

class RecyclerActivity : AppCompatActivity(), RecyclerAdapter.onClick {
    lateinit var binding:ActivityRecyclerBinding
    lateinit var recyclerAdapter: RecyclerAdapter
    var stuList= arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        stuList.add(Student(1,"Rohan","C"))
        stuList.add(Student(2,"Mohan","C++"))
        stuList.add(Student(3,"sahil","Java"))

        recyclerAdapter= RecyclerAdapter(stuList,this)
        binding.recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter=recyclerAdapter
    }

    override fun delete(position: Int) {
        Toast.makeText(this, "delete :${stuList[position]}", Toast.LENGTH_SHORT).show()
    }

    override fun update(position: Int) {
        Toast.makeText(this, "update :${stuList[position]}", Toast.LENGTH_SHORT).show()

    }

    override fun add(position: Int) {
        stuList.add(Student(stuList[position].rollNo?.plus(1),"Manav","Python"))
        recyclerAdapter.notifyDataSetChanged()
    }
}
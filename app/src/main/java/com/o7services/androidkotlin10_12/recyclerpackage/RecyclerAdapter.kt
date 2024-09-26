package com.o7services.androidkotlin10_12.recyclerpackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7services.androidkotlin10_12.R
import com.o7services.androidkotlin10_12.listpackage.Student

class RecyclerAdapter(var array: ArrayList<NotesEntity>, var clickInterface: onClick) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.tvStuName)
        var roll = view.findViewById<TextView>(R.id.tvRollno)
        var update = view.findViewById<Button>(R.id.btnUpdate)
        var delete = view.findViewById<Button>(R.id.btnDelete)
        var add = view.findViewById<Button>(R.id.btnAdd)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.base_item_layout, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.apply {
            name.setText(array[position].title)
            roll.setText(array[position].id.toString())
            update.setOnClickListener {
                clickInterface.update(position)
            }
            delete.setOnClickListener {
                clickInterface.delete(position)
            }
            add.setOnClickListener {
                clickInterface.add(position)
            }

        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

    interface onClick {
        fun delete(position: Int)
        fun update(position: Int)
        fun add(position: Int)
    }

}
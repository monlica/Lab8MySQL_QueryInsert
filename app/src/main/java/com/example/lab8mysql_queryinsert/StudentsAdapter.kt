package com.example.lab8mysql_queryinsert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8mysql_queryinsert.databinding.StdItemLayoutBinding

class StudentsAdapter(val studentList : ArrayList<Student>?, val context: Context)
    : RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View, val binding: StdItemLayoutBinding) :
        RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StdItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding

        binding.tvId.text = "ID: " + studentList!![position].std_id
        binding.tvName.text = "Name: " +studentList!![position].std_name
        binding.tvAge.text = "Age: " +studentList!![position].std_age.toString()
    }

    override fun getItemCount(): Int {
        return  studentList!!.size
    }
}
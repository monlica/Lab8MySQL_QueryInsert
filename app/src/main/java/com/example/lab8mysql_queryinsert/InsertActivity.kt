package com.example.lab8mysql_queryinsert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lab8mysql_queryinsert.databinding.ActivityInsertBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {
    private lateinit var bindingInsert : ActivityInsertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingInsert = ActivityInsertBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
    }

    fun addStudent(v: View) {
        val api: StudentAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI::class.java)
        api.insertStd(
            bindingInsert.edtId.text.toString(),
            bindingInsert.edtName.text.toString(),
            bindingInsert.edtAge.text.toString().toInt()
        ).enqueue(object : Callback<Student> {
            override fun onResponse(
                call: Call<Student>,
                response: retrofit2.Response<Student>
            ) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext,"Successfully Inserted", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Error ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Student>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure " + t.message,Toast.LENGTH_LONG).show()
            }
        })
    }

    fun resetStudent(v: View) {
        bindingInsert.edtId.text?.clear()
        bindingInsert.edtName.text?.clear()
        bindingInsert.edtAge.text?.clear()
    }
}
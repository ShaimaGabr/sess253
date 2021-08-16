package com.example.sess25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class data : AppCompatActivity() {
    lateinit var date:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        date=findViewById(R.id.text)
        date.text= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
}
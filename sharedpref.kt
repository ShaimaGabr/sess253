package com.example.sess25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class sharedpref : AppCompatActivity() {
    lateinit var edit:EditText
    lateinit var  text: TextView
    lateinit var button: Button
    lateinit var one:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpref)
        edit=findViewById(R.id.editText)
        text=findViewById(R.id.textView)
        button=findViewById(R.id.button)
        one=findViewById(R.id.one)
        val pref=getSharedPreferences("PREFS_NAME",MODE_PRIVATE)
        button.setOnClickListener {
            pref.edit()
                .putString("PREF_EMAIL", edit.text.toString())
                .apply()
            Toast.makeText(this,"done",Toast.LENGTH_SHORT).show()
        }
        one.setOnClickListener {
            val email=pref.getString("PREF_EMAIL", null)
            text.setText(email.toString())
        }

    }
}
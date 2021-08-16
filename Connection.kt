package com.example.sess25

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object Connection {
//    fun Retrofit_connection():Interfacedata{
//        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
//        addConverterFactory(GsonConverterFactory.create()).build().create(Interfacedata::class.java)
//    }
object Connection {
    fun Retrofit_connection():Interfacedata{
        return Retrofit.Builder().baseUrl("http://192.168.1.247/").
        addConverterFactory(GsonConverterFactory.create()).build().create(Interfacedata::class.java)
    }
}
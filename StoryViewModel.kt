package com.example.sess25.story

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sess25.Article
import com.example.sess25.Connection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class StoryViewModel:ViewModel() {
    var one="ahmed"
    var one1=MutableLiveData<String>("Ahmed3")
    var one2=MutableLiveData<String>("")
    ///////////////////////////////////////////
    var name=MutableLiveData<String>("")
    var phone=MutableLiveData<String>("")
    var address=MutableLiveData<String>("")
//    fun sendtofirebase(){
//        var map=HashMap<String,String>()
//        map["name"]=name.value!!
//        map["phone"]=phone.value!!
//        map["address"]=address.value!!
//        mdata.push().setvalue(map)
//    }
    ///////////////////////////////////////////////
    var newsList=MutableLiveData<List<Article>>() ///////////////////list artical such as model in Adapter
    ///////call api on response
    fun getdatafromserver(editText: EditText,context:Context){
        if(one2.value!!.isEmpty()){
            editText.error="please inter name"
        }else{
        CoroutineScope(Dispatchers.IO).async {
            val response            =Connection.Retrofit_connection().newsApi("","","","")
            CoroutineScope(Dispatchers.Main).async {
                if(response.isSuccessful){
                    newsList.value=response.body()!!.articles
                }else{
                    Toast.makeText(context,"failed${response.message()}",Toast.LENGTH_SHORT).show()
                }

            }
        }
        }


}
}
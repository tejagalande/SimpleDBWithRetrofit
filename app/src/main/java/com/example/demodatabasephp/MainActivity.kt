package com.example.demodatabasephp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.demodatabasephp.service.*
import com.example.demodatabasephp.service.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createUser(view: View){
        newUser()
    }

    private fun newUser(){

        var name = etName.text.toString().trim()
        var email = etEmail.text.toString().trim()
        var username = etUsername.text.toString().trim()
        var password = etPassword.text.toString().trim()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .baseUrl("http://192.168.1.5/User/")
            .build()

        val Api = retrofit.create(UserService::class.java)

        //val user = User(username = etUsername.text.toString().trim(), password = etPassword.text.toString().trim(), name = etName.text.toString().trim(), email = etEmail.text.toString().trim())

        val call = Api.create(name = "Nilesh", email = "nileshlinuxbox@gmail.com",username = "nilesh123",password = "nilesh123")


        call.enqueue( object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful && response.body() != null){
                    Log.d("Response.Success ",response.message().toString())
                    Log.d("Response.body ",response.body().toString())
                    Log.d("Response.Code ",response.code().toString())
                    Toast.makeText(this@MainActivity,"User added Successfully",Toast.LENGTH_SHORT).show()
                    var success = response.body()

                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

                Log.e("Response.Failure ",t.message.toString())

                Toast.makeText(this@MainActivity,"Can't added user to database",Toast.LENGTH_SHORT).show()
            }

        } )
    }

}
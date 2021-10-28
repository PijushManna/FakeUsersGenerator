package com.example.fakeusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.fakeusers.database.Result
import com.example.fakeusers.databinding.ActivityMainBinding
import com.example.fakeusers.localdb.Users
import com.example.fakeusers.localdb.UsersDao
import com.example.fakeusers.localdb.UsersDatabase
import com.google.gson.GsonBuilder
import java.util.*


class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val requestQueue by lazy {
        Volley.newRequestQueue(baseContext)
    }
    private val viewModel:MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private val database:UsersDao by lazy {
        UsersDatabase.getInstance(applicationContext).usersDao
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.setRequestQueue(requestQueue)

        viewModel.fetchData(database)
        val adapter  =UserAdapter()
        binding.rcrData.adapter = adapter
        database.getData().observe(this,{
            adapter.submitList(it)
        })
    }
}
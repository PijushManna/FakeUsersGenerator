package com.example.fakeusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.fakeusers.database.Result
import com.example.fakeusers.databinding.ActivityMainBinding
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.setRequestQueue(requestQueue)
        viewModel.newPerson.observe(this,{ it1 ->
            it1.results?.get(0)?.also { user ->
                binding.apply {
                    Glide.with(baseContext).load(user.picture?.large)
                        .placeholder(R.drawable.loading)
                        .into(imgPerson)
                    "${user.name?.title} ${user.name?.first} ${user.name?.last}".also { txtPersonName.text = it }
                    txtEmail.text = user.email
                    txtGender.text = user.gender
                    txtCity.text = user.location?.city ?: getString(R.string.not_found)
                    txtState.text = user.location?.state
                    "${user.location?.street?.number} ${user.location?.street?.name}".also { txtStreet.text = it }
                    txtPhone.text = user.phone
                    txtDob.text = user.dob?.date ?: Date().toString()
                    txtCountry.text = user.location?.country ?: "US"
                    txtPin.text = user.location?.postcode.toString()
                    txtAge.text = user.dob?.age.toString()
                    txtNationality.text = user.nat
                    "( ${user.location?.coordinates?.latitude} , ${user.location?.coordinates?.longitude} )".also { txtCord.text = it }
                    txtTimeZone.text = user.location?.timezone?.description
                }
            }
        })

        binding.btnGenereate.setOnClickListener {
            viewModel.fetchData()
        }
    }
}
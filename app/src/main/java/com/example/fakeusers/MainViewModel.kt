package com.example.fakeusers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.fakeusers.database.FakeUser
import com.example.fakeusers.localdb.Users
import com.example.fakeusers.localdb.UsersDao
import com.google.gson.GsonBuilder

class MainViewModel : ViewModel() {
    private var requestQueue: RequestQueue? = null
    private val _newPerson = MutableLiveData<FakeUser>()
    val newPerson: LiveData<FakeUser> = _newPerson
    private val gson  = GsonBuilder().create()

    fun setRequestQueue(item: RequestQueue?) {
        requestQueue = item
    }

    fun fetchData(database:UsersDao) {
        val request = StringRequest(
            BASE_URL,
            {
                it?.let {
                    gson.fromJson(it,FakeUser::class.java).also { data ->
                        data.results?.forEach {
                            database.insert(
                                Users(
                                    name = it.name?.first,
                                    email = it.email,
                                    number = it.phone,
                                    image = it.picture?.thumbnail
                                )
                            )
                        }

                    }
                }
            },
            {
                Log.i("Response",it.toString())
            }
        )
        requestQueue?.add(request)
    }

    companion object {
        const val BASE_URL = "https://randomuser.me/api/?results=100"
    }
}
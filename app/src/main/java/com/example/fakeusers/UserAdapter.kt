package com.example.fakeusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fakeusers.databinding.ActivityMainBinding
import com.example.fakeusers.databinding.LayoutUsersBinding
import com.example.fakeusers.localdb.Users


class UserAdapter : ListAdapter<Users,UserAdapter.ViewHolder>(UsersDiffUtilCallback()){
    class ViewHolder(private val binding: LayoutUsersBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:Users){
            Glide.with(binding.root.context).load(item.image).into(binding.imgPerson)
            binding.txtEmail.text = item.email
            binding.txtPersonName.text = item.name
            binding.txtPhone.text = item.number
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutUsersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
}

class UsersDiffUtilCallback: DiffUtil.ItemCallback<Users>(){
    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }
}

package com.example.retrofitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofitdemo.databinding.ActivityUserBinding
import com.example.retrofitdemo.model.User

class UserActivity: AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user= intent.extras?.get("user") as User
        Glide.with(this).load(user.avatarUrl).into(binding.ivAvatar)
        binding.apply{
            tvLogin.text = user.login
            tvName.text = user.name
            tvBio.text = user.bio
            tvFollowers.text = user.followers.toString()
            tvFollowing.text = user.following.toString()
        }
    }
}
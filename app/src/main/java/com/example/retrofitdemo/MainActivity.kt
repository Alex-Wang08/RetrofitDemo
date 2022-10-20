package com.example.retrofitdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.retrofitdemo.api.ApiFactory
import com.example.retrofitdemo.api.UserService
import com.example.retrofitdemo.databinding.ActivityMainBinding
import com.example.retrofitdemo.model.User
import com.example.retrofitdemo.state.Status
import com.example.retrofitdemo.viewmodel.UserViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btSearch.setOnClickListener {

            viewModel.getUser(binding.etSearch.text.toString())

            lifecycleScope.launch {
                viewModel.userState.collect{
                    when (it.status){
                        Status.SUCCESS -> {
                            val intent = Intent(this@MainActivity, UserActivity::class.java)
                            intent.putExtra("user", it.data)
                            startActivity(intent)
                        }
                        else -> {}
                    }
                }
            }

        }
    }

}


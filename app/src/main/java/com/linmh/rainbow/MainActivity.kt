package com.linmh.rainbow

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.linmh.rainbow.data.Repository
import com.linmh.rainbow.data.ResultData
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    public val viewModel by lazy { ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home,R.id.detailFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
}
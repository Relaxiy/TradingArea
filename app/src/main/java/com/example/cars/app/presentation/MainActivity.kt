package com.example.cars.app.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.R
import com.example.cars.app.di.DaggerMainActivityComponent
import com.example.cars.app.di.MainActivityComponent
import com.example.cars.utils.ext.openFragment
import com.example.cars.app.presentation.mainPage.MainPageFragment
import com.example.cars.databinding.ActivityMainBinding
import com.example.cars.utils.ext.appComponent
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val bottomNav by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    private val mainActivityViewModel: MainActivityViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    lateinit var mainActivityComponent: MainActivityComponent

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .context(this)
                .viewStore(this)
                .build()

        initHomeFragment()
    }

    override fun onStart() {
        super.onStart()
        mainActivityViewModel.initBottomNavMenu(binding, bottomNav, this)
    }

    private fun initHomeFragment() {
        openFragment(MainPageFragment.newInstance(), MainPageFragment.TAG, R.id.container)
    }


}
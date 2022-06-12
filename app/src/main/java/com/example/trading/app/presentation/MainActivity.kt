package com.example.trading.app.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.trading.R
import com.example.trading.app.di.DaggerMainActivityComponent
import com.example.trading.app.di.MainActivityComponent
import com.example.trading.utils.ext.openFragment
import com.example.trading.app.presentation.mainPage.MainPageFragment
import com.example.trading.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val bottomNav by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    private val mainActivityViewModel: MainActivityViewModel by viewModels {
        mainActivityComponent.viewModelsFactory()
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
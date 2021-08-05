package com.example.harajtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.harajtask.R
import com.example.harajtask.databinding.ActivityBaseBinding
import com.example.harajtask.presentation.di.Injector
import javax.inject.Inject

class BaseActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "BaseActivity"
    }

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory
    private lateinit var viewModel: BaseViewModel
    private lateinit var binding: ActivityBaseBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)

        (application as Injector).createBaseSubComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(BaseViewModel::class.java)


        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fcv.id) as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(binding.mt)

        binding.mt.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_burger)


        setContentView(binding.root)

    }
}
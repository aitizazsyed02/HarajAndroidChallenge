package com.example.harajtask.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.harajtask.R

class BaseActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "BaseActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
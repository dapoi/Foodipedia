package com.dapascript.foodipedia.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dapascript.foodipedia.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
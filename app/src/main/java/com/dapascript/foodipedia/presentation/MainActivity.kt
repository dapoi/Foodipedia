package com.dapascript.foodipedia.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dapascript.foodipedia.R
import com.dapascript.foodipedia.presentation.viewmodel.SplashScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { splashScreenViewModel.splashScreenFinished.value }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
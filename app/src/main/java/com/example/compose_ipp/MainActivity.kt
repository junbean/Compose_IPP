package com.example.compose_ipp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.compose_ipp.animation_project.SimpleAnimationPage
import com.example.compose_ipp.bottom_navigation_project.pages.MainScreen
import com.example.compose_ipp.ui.theme.Compose_IPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //네비게이션 기능
        /*
        setContent{
            MyAppNavigation()
        }
        */

        //상태 관리 기능
        /*
        val viewModel = ViewModelProvider(this)[StateTestViewModel::class.java]
        setContent {
            StateTestScreen(viewModel)
        }
        */

        //하단 네비게이션
        /*
        setContent{
            Compose_IPPTheme {
                MainScreen()
            }
        }
        */

        //애니메이션
        /*
        setContent{
            Compose_IPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleAnimationPage(Modifier.padding(innerPadding))
                }
            }
        }
        */

        //api 통신
        val weatherViewModel =  ViewModelProvider(this)[WeatherViewModel::class.java]
        setContent{
            WeatherPage(weatherViewModel)
        }

    }
}

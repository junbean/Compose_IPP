package com.example.compose_ipp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose_ipp.tablayout_viewpager_project.MainScreen
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
        /*
        val weatherViewModel =  ViewModelProvider(this)[WeatherViewModel::class.java]
        setContent{
            WeatherPage(weatherViewModel)
        }
        */

        //MVVM모델 구축
        /*
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
        setContent{
            Compose_IPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePage(modifier = Modifier.padding(innerPadding), homeViewModel)
                }
            }
        }
        */

        //gemini chatbot 만들기
        /*
        enableEdgeToEdge()
        val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        setContent {
            Compose_IPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChatPage(modifier = Modifier.padding(innerPadding), viewModel = chatViewModel)
                }
            }
        }
        */

        //horizontalPager - 뷰페이저
        /*
        setContent {
            Compose_IPPTheme {
                MainScreen()

            }
        }
        */

        //ClipTabRow - 탭레이아웃
        setContent {
            Compose_IPPTheme {
                MainScreen()
            }
        }

        //뷰페이저 + 탭레이아웃
        /*
        setContent {
            Compose_IPPTheme {
                MainScreen()
            }
        }
        */
    }
}

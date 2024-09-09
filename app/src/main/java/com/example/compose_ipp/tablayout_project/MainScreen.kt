package com.example.compose_ipp.tablayout_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.compose_ipp.tablayout_viewpager_project.FirstScreen
import com.example.compose_ipp.tablayout_viewpager_project.SecondScreen
import com.example.compose_ipp.tablayout_viewpager_project.ThirdScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalPagerApi::class)
fun MainScreen() {
    val tabItems = listOf(
        TabItem
    )
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
          selectedTabIndex =
        ) {

        }


    }
}

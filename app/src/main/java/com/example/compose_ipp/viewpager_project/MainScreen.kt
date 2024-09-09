package com.example.compose_ipp.viewpager_project

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ipp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Screen()
        Spacer(modifier = Modifier.height(10.dp))
        InfiniteScreen()
        Spacer(modifier = Modifier.height(10.dp))
        AutoScreen()
    }
}

//뷰페이저 ===========================================================================================
@Composable
fun Screen() {
    val pageCount = 10
    val pagerState = rememberPagerState(
        pageCount = { pageCount }
    )
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        Log.d("state changed", "pager state changed : ${pagerState.currentPage + 1}")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "뷰페이저", fontSize = 25.sp)
        Text(text = "pageCount : ${pagerState.pageCount}")
        Text(text = "currentPage : ${pagerState.currentPage}")
        ViewPager(pagerState = pagerState)
        Indicator(pagerState)
        MoveButton(pagerState, coroutineScope)
    }
}

//무한 스크롤 뷰페이저 ===========================================================================================
@Composable
fun InfiniteScreen() {
    val actualCount = 10
    val virtualCount = actualCount * 1000
    val initialPage = virtualCount / 2
    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { virtualCount }
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "무한 스크롤 뷰페이저", fontSize = 25.sp)
        Text(text = "pageCount : ${pagerState.pageCount}")
        Text(text = "currentPage : ${pagerState.currentPage}")
        InfiniteViewPager(pagerState)
        InfiniteIndicator(pagerState, actualCount)
        //MoveButton(pagerState, coroutineScope)
    }
}

//리스트 화면 출력 & 자동 뷰페이저 =======================================================================
@Composable
fun AutoScreen() {
    val itemList = listOf(
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    )
    val pagerCount = itemList.size * 10000
    val initialPage = pagerCount/2

    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { pagerCount }
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "자동 뷰페이저", fontSize = 25.sp)
        Text(text = "pageCount : ${pagerState.pageCount}")
        Text(text = "currentPage : ${pagerState.currentPage}")
        AutoViewPager(pagerState, itemList)
        InfiniteIndicator(pagerState, itemList.size)
    }
}


//인디케이터 ==================================================================================================
@Composable
fun Indicator(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}

@Composable
fun InfiniteIndicator(pagerState: PagerState, actualCount : Int){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(actualCount) { iteration ->
            val color = if ((pagerState.currentPage % actualCount) == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}

//이동 버튼 ===============================================================================================
@Composable
fun MoveButton(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = {
                coroutineScope.launch {
                    //그냥 애니메이션 없이 이동
                    //pagerState.scrollToPage(0)
                    //애니메이션 이동
                    pagerState.animateScrollToPage(0)
                }
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_left_double_arrow),
                contentDescription = "move left"
            )
        }

        IconButton(
            onClick = {
                coroutineScope.launch {
                    //그냥 애니메이션 없이 이동
                    //pagerState.scrollToPage(if (pagerState.currentPage == 0) 0 else pagerState.currentPage - 1)
                    //애니메이션 이동
                    pagerState.animateScrollToPage(if (pagerState.currentPage == 0) 0 else pagerState.currentPage - 1)
                }
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = "move left"
            )
        }

        IconButton(
            onClick = {
                coroutineScope.launch {
                    //그냥 애니메이션 없이 이동
                    //pagerState.scrollToPage(if (pagerState.currentPage == 9) 9 else pagerState.currentPage + 1)
                    //애니메이션 이동
                    pagerState.animateScrollToPage(if (pagerState.currentPage == 9) 9 else pagerState.currentPage + 1)
                }
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = "move right"
            )
        }

        IconButton(
            onClick = {
                coroutineScope.launch {
                    //그냥 애니메이션 없이 이동
                    //pagerState.scrollToPage(9)
                    //애니메이션 이동
                    pagerState.animateScrollToPage(9)
                }
            }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_right_double_arrow),
                contentDescription = "move right"
            )
        }
    }
}
package com.example.compose_ipp.viewpager_project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val AUTO_PAGE_CHANGE_DELAY = 4000L

@Composable
fun AutoViewPager(pagerState: PagerState, itemList: List<String>) {
    // 자동 스크롤 상태
    var isDragging by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    //초기 설정 - 처음 마운트 시에만 실행
    LaunchedEffect(Unit) {

    }

    //지정된 시간마다 auto scroll 
    LaunchedEffect(key1 = pagerState.currentPage, key2 = isDragging) {
        if (!isDragging) {
            coroutineScope.launch {
                delay(AUTO_PAGE_CHANGE_DELAY) // 3초 대기 후 자동으로 다음 페이지로 이동
                val nextPage = pagerState.currentPage + 1
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }
    //val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount

    //페이지를 마우스로 드래그
    LaunchedEffect(pagerState.isScrollInProgress) {
        isDragging = pagerState.isScrollInProgress
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 30.dp),
        pageSpacing = 30.dp
    ) { page ->

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Page ${itemList[(page % itemList.size)]}"
                )
            }
        }
    }
}
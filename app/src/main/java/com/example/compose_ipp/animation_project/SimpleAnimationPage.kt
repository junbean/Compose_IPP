package com.example.compose_ipp.animation_project

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_ipp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun SimpleAnimationPage(modifier: Modifier = Modifier) {
    var scale = remember {
        Animatable(0f)
    }

    var animateAgain by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = false){
        scale.animateTo(
            targetValue = 1f,
            //targetValue = 360f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .weight(1f)
                //.rotate(scale.value),
                .scale(scale.value),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "logo"
        )
        Button(
            onClick = {
                GlobalScope.launch {
                    scale.snapTo(0f)
                }
                animateAgain = !animateAgain
            }
        ) {
            Text(text = "Animate")
        }
    }
}
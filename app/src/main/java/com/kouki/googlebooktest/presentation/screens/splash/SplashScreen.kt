package com.kouki.googlebooktest.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.navigation.Screen
import com.kouki.googlebooktest.ui.theme.Purple200
import com.kouki.googlebooktest.ui.theme.Purple500
import kotlinx.coroutines.async


@Composable
fun SplashScreen(
    navController: NavHostController
) {
    val degrees = remember { Animatable(0f) }
    val size = remember { Animatable(240f) }

    // Rotate animation
    LaunchedEffect(key1 = true) {
        // TODO find best way to async coroutine, but it works for now
        async {
            degrees.animateTo(
                targetValue = 720f,
                animationSpec = tween(
                    durationMillis = 1000,
                    delayMillis = 200
                )
            )
        }
        async{
            size.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 1000,
                    delayMillis = 200
                )
            )
        }.await()
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    Splash(degrees = degrees.value, size = size.value)
}

@Composable
fun Splash(
    degrees: Float,
    size: Float
) {
    Box(
        modifier = Modifier
            .background(Brush.verticalGradient(listOf(Purple500, Purple200)))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(size.dp)
                .rotate(degrees = degrees),
            painter = painterResource(id = R.drawable.ic_icons8_google_books),
            contentDescription = stringResource(R.string.app_logo)
        )
    }
}


@Composable
@Preview
fun SplashScreenPreview() {
}
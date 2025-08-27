package com.dadehfa.toranj.features.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dadehfa.toranj.common.ui.theme.BrandColor
import com.dadehfa.toranj.common.ui.theme.padding
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds
import com.dadehfa.toranj.common.ui.R as CommonUiR

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToLogin: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.padding.large)
            .then(modifier)
    ) {
        Image(
            painter = painterResource(CommonUiR.drawable.app_icon),
            contentDescription = "app_logo",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth(0.2F)
                .align(Alignment.BottomCenter),
            color = BrandColor,
            strokeCap = StrokeCap.Round
        )
    }

    LaunchedEffect(Unit) {
        delay(1.seconds)
        onNavigateToLogin()
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(
        onNavigateToLogin = {}
    )
}

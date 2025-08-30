package com.dadehfa.toranj.presentation

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dadehfa.toranj.common.ui.theme.ToranjTheme
import com.dadehfa.toranj.features.dashboard.presentation.DashboardScreen
import com.dadehfa.toranj.features.dashboard.presentation.SettingScreen
import com.dadehfa.toranj.features.operations.presentation.OperationViewModel
import com.dadehfa.toranj.features.operations.presentation.OperationsEvent
import com.dadehfa.toranj.features.operations.presentation.OperationsScreen
import com.dadehfa.toranj.features.register.presentation.RegisterContract
import com.dadehfa.toranj.features.register.presentation.RegisterScreen
import com.dadehfa.toranj.features.register.presentation.RegisterViewModel
import com.dadehfa.toranj.features.splash.presentation.SplashScreen
import com.dadehfa.toranj.presentation.nav.MainNavBars
import com.dadehfa.toranj.presentation.nav.MainNavigation
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    navGraph: NavHostController
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navGraph,
        startDestination = MainNavigation.SplashScreen,
    ) {
        composable<MainNavigation.HomeScreen> {

            var selectedItem by remember { mutableStateOf(MainNavBars.Operations) }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    NavigationBar {
                        MainNavBars.Operations.run {
                            NavigationBarItem(
                                selected = selectedItem == this,
                                onClick = {
                                    selectedItem = this
                                },
                                icon = {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = title
                                    )
                                }
                            )
                        }
                        MainNavBars.Dashboard.run {
                            NavigationBarItem(
                                selected = selectedItem == this,
                                onClick = {
                                    selectedItem = this
                                },
                                icon = {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = title
                                    )
                                }
                            )
                        }
                        MainNavBars.Setting.run {
                            NavigationBarItem(
                                selected = selectedItem == this,
                                onClick = {
                                    selectedItem = this
                                },
                                icon = {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null
                                    )
                                },
                                label = {
                                    Text(
                                        text = title
                                    )
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                AnimatedContent(
                    modifier = Modifier.padding(innerPadding),
                    targetState = selectedItem
                ) { targetState ->
                    when (targetState) {
                        MainNavBars.Operations -> {

                            val viewModel = viewModel<OperationViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            OperationsScreen(
                                state = state,
                                onEvent = { event ->
                                    when (event) {
                                        is OperationsEvent.OnSelectedMenu -> {
                                            // Navigate To Item Screen
                                        }

                                        else -> viewModel.onEvent(event)
                                    }
                                }
                            )
                        }

                        MainNavBars.Dashboard -> {
                            DashboardScreen()
                        }

                        MainNavBars.Setting -> {
                            SettingScreen()
                        }
                    }
                }
            }
        }
        composable<MainNavigation.SplashScreen> {
            SplashScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateToRegister = {
                    navGraph.navigate(MainNavigation.RegisterScreen) {
                        popUpTo(navGraph.graph.startDestinationId) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<MainNavigation.RegisterScreen> {

            val context = LocalContext.current

            val viewModel = koinViewModel<RegisterViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val effect by viewModel.effect.collectAsStateWithLifecycle(RegisterContract.Effect.Idle)

            LaunchedEffect(key1 = effect) {
                val curEffect = effect
                when (curEffect) {
                    is RegisterContract.Effect.ShowToast -> {
                        Toast.makeText(context, curEffect.message, Toast.LENGTH_SHORT).show()
                    }

                    is RegisterContract.Effect.NavigateToHome -> {
                        navGraph.navigate(MainNavigation.HomeScreen) {
                            restoreState = true
                            launchSingleTop = true
                        }
                    }

                    else -> {}
                }
            }

            RegisterScreen(
                modifier = Modifier.fillMaxSize(),
                state = state,
                onIntent = viewModel::setIntent
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun MainScreenPreview() {
    val navGraph = rememberNavController()
    ToranjTheme {
        MainScreen(navGraph = navGraph)
    }
}

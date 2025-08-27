package com.dadehfa.toranj.features.register.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dadehfa.toranj.common.ui.component.DefaultEditText
import com.dadehfa.toranj.common.ui.component.DefaultEditTextPassword
import com.dadehfa.toranj.common.ui.theme.padding
import com.dadehfa.toranj.features.register.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: RegisterState,
    onEvent: (event: RegisterEvent) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.register_screen)
                    )
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(
                    space = MaterialTheme.padding.medium,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Surface(
                    shape = MaterialTheme.shapes.large,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.8F)
                            .padding(MaterialTheme.padding.large),
                        verticalArrangement = Arrangement.spacedBy(
                            space = MaterialTheme.padding.medium,
                            alignment = Alignment.Top
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        DefaultEditText(
                            label = stringResource(R.string.register_username_label),
                            value = state.username,
                            leadingIcon = Icons.Rounded.Person,
                            onValueChange = { username ->
                                onEvent(RegisterEvent.OnUsernameChange(username))
                            }
                        )
                        DefaultEditTextPassword(
                            label = stringResource(R.string.register_password_label),
                            value = state.password,
                            onValueChange = { password ->
                                onEvent(RegisterEvent.OnPasswordChange(password))
                            }
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = state.isRememberMe,
                                onCheckedChange = { isRememberMe ->
                                    onEvent(RegisterEvent.OnRememberMeChange(isRememberMe))
                                }
                            )
                            Text(
                                text = stringResource(R.string.register_remember_me)
                            )
                        }
                    }
                }

                Button(
                    modifier = Modifier.fillMaxWidth(0.8F),
                    shape = MaterialTheme.shapes.large,
                    onClick = {
                        onEvent(RegisterEvent.OnLoginClick)
                    }
                ) {
                    Text(
                        text = stringResource(R.string.register_apply_btn)
                    )
                }

            }
        }
    )
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        state = RegisterState(
            username = "yusefpasha",
            password = "0912345678",
        ),
        onEvent = {}
    )
}

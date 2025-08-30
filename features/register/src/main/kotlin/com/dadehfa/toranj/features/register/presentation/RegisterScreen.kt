package com.dadehfa.toranj.features.register.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun RegisterScreen(
    modifier: Modifier = Modifier,
    state: RegisterContract.State,
    onIntent: (event: RegisterContract.Intent) -> Unit
) {

    var username by remember { mutableStateOf("emilys") }
    var password by remember { mutableStateOf("emilyspass") }
    var isRememberMe by remember { mutableStateOf(false) }

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
                            value = username,
                            leadingIcon = Icons.Rounded.Person,
                            onValueChange = { newUsername ->
                                username = newUsername
                            }
                        )
                        DefaultEditTextPassword(
                            label = stringResource(R.string.register_password_label),
                            value = password,
                            onValueChange = { newPassword ->
                                password = newPassword
                            }
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Checkbox(
                                checked = isRememberMe,
                                onCheckedChange = { newIsRememberMe ->
                                    isRememberMe = newIsRememberMe
                                }
                            )
                            Text(
                                text = stringResource(R.string.register_remember_me)
                            )
                        }
                    }
                }

                when (val s = state) {
                    is RegisterContract.State.Idle -> {
                        Button(
                            modifier = Modifier.fillMaxWidth(0.8F),
                            shape = MaterialTheme.shapes.large,
                            onClick = {
                                onIntent(
                                    RegisterContract.Intent.Login(
                                        username,
                                        password
                                    )
                                )
                            }
                        ) {
                            Text(
                                text = stringResource(R.string.register_apply_btn)
                            )
                        }
                    }

                    is RegisterContract.State.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxWidth(0.2F)
                        )
                    }

                    is RegisterContract.State.Success -> {
                        Text(
                            modifier = Modifier.fillMaxWidth(0.8F),
                            text = stringResource(
                                R.string.register_login_successfully_message,
                                s.firstName
                            )
                        )
                    }

                    is RegisterContract.State.Failure -> {
                        Text(
                            modifier = Modifier.fillMaxWidth(0.8F),
                            text = stringResource(
                                R.string.register_login_failure_message,
                                s.message
                            ),
                            color = MaterialTheme.colorScheme.error
                        )
                        Spacer(modifier = Modifier.height(MaterialTheme.padding.medium))
                        Button(onClick = {
                            onIntent(
                                RegisterContract.Intent.Login(
                                    username,
                                    password
                                )
                            )
                        }) {
                            Text(
                                text = stringResource(R.string.register_try_again)
                            )
                        }
                    }
                }

            }
        }
    )
}

@Preview
@Composable
private fun LoginScreenPreview() {
    RegisterScreen(
        state = RegisterContract.State.Idle,
        onIntent = {}
    )
}

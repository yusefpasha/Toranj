package com.dadehfa.toranj.common.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.dadehfa.toranj.common.ui.theme.ToranjTheme
import com.dadehfa.toranj.common.ui.theme.padding

@Composable
fun DefaultEditText(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    leadingIcon: ImageVector,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label
            )
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = leadingIcon.name
            )
        },
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun DefaultEditTextPassword(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Rounded.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "hide_password" else "show_password"

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        shape = MaterialTheme.shapes.medium,
    )
}

@PreviewLightDark
@Composable
private fun DefaultEditTextPreview() {
    ToranjTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.padding.large),
            contentAlignment = Alignment.Center
        ) {
            DefaultEditText(
                label = "Username",
                value = "yusefpasha",
                leadingIcon = Icons.Rounded.Person,
                onValueChange = {}
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun DefaultEditTextPasswordPreview() {
    ToranjTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.padding.large),
            contentAlignment = Alignment.Center
        ) {
            DefaultEditTextPassword(
                label = "Password",
                value = "09123456789",
                onValueChange = {}
            )
        }
    }
}

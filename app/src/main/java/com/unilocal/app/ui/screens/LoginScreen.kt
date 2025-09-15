package com.unilocal.app.ui.screens

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.unilocal.app.R
import com.unilocal.app.ui.components.InputText

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    onChangePasswordClick: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.login_title),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Text(
                text = stringResource(R.string.login_welcome),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            InputText(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.login_email_label),
                supportingText = context.getString(R.string.login_email_error),
                onValidate = { it.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(it).matches() },
                placeholder = stringResource(R.string.login_email_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                value = password,
                onValueChange = { password = it },
                label = stringResource(R.string.login_password_label),
                supportingText = context.getString(R.string.login_password_error),
                onValidate = { it.isBlank() || it.length < 6 },
                isPassword = true,
                placeholder = stringResource(R.string.login_password_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            TextButton(
                onClick = onChangePasswordClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = stringResource(R.string.login_forgot_password))
            }

            Button(
                onClick = onLoginSuccess,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                enabled = email.isNotEmpty() && password.isNotEmpty()
            ) {
                Text(text = stringResource(R.string.login_button))
            }

            TextButton(onClick = onRegisterClick) {
                Text(text = stringResource(R.string.login_register_prompt))
            }
        }

    }
}
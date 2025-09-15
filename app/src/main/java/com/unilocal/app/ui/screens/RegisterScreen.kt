package com.unilocal.app.ui.screens

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
fun RegisterScreen(
    onLoginClick: () -> Unit,
    //onRegisterSuccess: () -> Unit
) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var city by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    // Validaciones
    val isFullNameValid = fullName.isNotEmpty()
    val isUsernameValid = username.isNotEmpty()
    val isEmailValid = email.isNotEmpty() && email.contains("@")
    val isCityValid = city.isNotEmpty()
    val isPasswordValid = password.length >= 6
    val isConfirmPasswordValid = confirmPassword == password && confirmPassword.isNotEmpty()

    val isFormValid = isFullNameValid && isUsernameValid && isEmailValid && isCityValid && isPasswordValid && isConfirmPasswordValid

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.register_title),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Text(
                text = stringResource(R.string.register_welcome),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            InputText(
                value = fullName,
                onValueChange = { fullName = it },
                label = stringResource(R.string.register_full_name_label),
                supportingText = context.getString(R.string.register_full_name_error),
                onValidate = { it.isEmpty() },
                placeholder = stringResource(R.string.register_full_name_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                value = username,
                onValueChange = { username = it },
                label = stringResource(R.string.register_username_label),
                supportingText = context.getString(R.string.register_username_error),
                onValidate = { it.isEmpty() },
                placeholder = stringResource(R.string.register_username_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.register_email_label),
                supportingText = context.getString(R.string.register_email_error),
                onValidate = { it.isEmpty() || !it.contains("@") },
                placeholder = stringResource(R.string.register_email_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                value = city,
                onValueChange = { city = it },
                label = stringResource(R.string.register_city_label),
                supportingText = context.getString(R.string.register_city_error),
                onValidate = { it.isEmpty() },
                placeholder = stringResource(R.string.register_city_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                value = password,
                onValueChange = { password = it },
                label = stringResource(R.string.register_password_label),
                supportingText = context.getString(R.string.register_password_error),
                onValidate = { it.isEmpty() || it.length < 6 },
                isPassword = true,
                placeholder = stringResource(R.string.register_password_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InputText(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = stringResource(R.string.register_confirm_password_label),
                supportingText = context.getString(R.string.register_confirm_password_error),
                onValidate = { it != password },
                isPassword = true,
                placeholder = stringResource(R.string.register_confirm_password_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                enabled = isFormValid
            ) {
                Text(text = stringResource(R.string.register_button))
            }

            TextButton(onClick = onLoginClick) {
                Text(text = stringResource(R.string.register_login_prompt))
            }
        }
    }

}
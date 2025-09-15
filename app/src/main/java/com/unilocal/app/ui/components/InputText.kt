package com.unilocal.app.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    supportingText: String,
    onValueChange: (String) -> Unit,
    onValidate: (String) -> Boolean,
    icon: ImageVector? = null,
    isPassword: Boolean = false,
    placeholder: String,
) {

    var isError by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        value = value,
        label = { if (label.isNotEmpty()) Text(label) },
        supportingText = {
            if (isError) {
                Text(text = supportingText)
            }
        },
        leadingIcon = {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = label)
            }

        },
        onValueChange = {
            onValueChange(it)
            isError = onValidate(it)
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = { if (placeholder.isNotEmpty()) Text(placeholder) },

    )
}

package com.unilocal.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PurplePrimary,
    onPrimary = WhiteText,
    secondary = GoldAccent,
    onSecondary = BlackBackground,
    background = BlackBackground,
    surface = BlackBackground,
    onBackground = WhiteText,
    onSurface = WhiteText,
)

private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,
    onPrimary = WhiteText,
    secondary = GoldAccent,
    onSecondary = BlackBackground,
    background = Color.White,
    surface = Color.White,
    onBackground = BlackBackground,
    onSurface = BlackBackground,
)

@Composable
fun UniLocalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Desactivamos dynamic para mantener la paleta personalizada
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

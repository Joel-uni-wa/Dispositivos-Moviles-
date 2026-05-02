/*
 * Descripción: Configura el tema visual de la app (colores claro/oscuro y tipografía)
 *              utilizando Material 3 con soporte para Dynamic Color en Android 12+.
 * Autor: Joel Choquepata Guarniz
 * Fecha de creación: 02/05/2026
 * Fecha de última modificación: 02/05/2026
 */

package com.example.gestorcontactos.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Esquema de colores para modo oscuro
private val DarkColorScheme = darkColorScheme(
    primary   = Blue80,
    secondary = BlueGrey80,
    tertiary  = Amber80
)

// Esquema de colores para modo claro
private val LightColorScheme = lightColorScheme(
    primary   = Blue40,
    secondary = BlueGrey40,
    tertiary  = Amber40
)

// Composable que aplica el tema a todos los hijos del árbol de composición
@Composable
fun GestorContactosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Colores dinámicos disponibles en Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Selecciona el esquema de colores según el modo y la versión de Android
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else      -> LightColorScheme
    }

    // Sincroniza el color de la barra de estado con el color primario del tema
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography,
        content     = content
    )
}

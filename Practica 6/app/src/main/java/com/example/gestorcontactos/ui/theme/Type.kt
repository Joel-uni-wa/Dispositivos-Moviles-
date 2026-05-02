/*
 * Descripción: Define la tipografía base de la aplicación usando el sistema de Material 3.
 * Autor: Joel Choquepata Guarniz
 * Fecha de creación: 02/05/2026
 * Fecha de última modificación: 02/05/2026
 */

package com.example.gestorcontactos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Tipografía estándar de Material 3 para toda la aplicación
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

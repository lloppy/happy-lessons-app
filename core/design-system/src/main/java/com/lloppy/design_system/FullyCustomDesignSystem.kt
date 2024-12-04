package com.lloppy.design_system

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object FullyCustomDesignSystem {
    @Immutable
    data class CustomColors(
        val content: Color,
        val component: Color,
        val background: List<Color>
    )

    @Immutable
    data class CustomTypography(
        val body: TextStyle,
        val title: TextStyle
    )

    @Immutable
    data class CustomElevation(
        val default: Dp,
        val pressed: Dp
    )

    val LocalCustomColors = staticCompositionLocalOf {
        CustomColors(
            content = Color.Unspecified,
            component = Color.Unspecified,
            background = emptyList()
        )
    }
    val LocalCustomTypography = staticCompositionLocalOf {
        CustomTypography(
            body = TextStyle.Default,
            title = TextStyle.Default
        )
    }
    val LocalCustomElevation = staticCompositionLocalOf {
        CustomElevation(
            default = Dp.Unspecified,
            pressed = Dp.Unspecified
        )
    }

    @Composable
    fun CustomTheme(
        /* ... */
        content: @Composable () -> Unit
    ) {
        val customColors = CustomColors(
            content = Color(0xFFDD0D3C),
            component = Color(0xFFC20029),
            background = listOf(Color.White, Color(0xFFF8BBD0))
        )
        val customTypography = CustomTypography(
            body = TextStyle(fontSize = 16.sp),
            title = TextStyle(fontSize = 32.sp)
        )
        val customElevation = CustomElevation(
            default = 4.dp,
            pressed = 8.dp
        )
        CompositionLocalProvider(
            LocalCustomColors provides customColors,
            LocalCustomTypography provides customTypography,
            LocalCustomElevation provides customElevation,
            content = content
        )
    }

    object CustomTheme {
        val colors: CustomColors
            @Composable
            get() = LocalCustomColors.current
        val typography: CustomTypography
            @Composable
            get() = LocalCustomTypography.current
        val elevation: CustomElevation
            @Composable
            get() = LocalCustomElevation.current
    }
}
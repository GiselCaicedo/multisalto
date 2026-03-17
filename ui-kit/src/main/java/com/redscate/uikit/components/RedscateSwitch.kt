package com.redscate.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.redscate.uikit.R
import com.redscate.uikit.theme.RedscateThemeTokens

enum class RedscateSwitchVariant {
    Standard,
    LeftAccent
}

@Composable
fun RedscateSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: RedscateSwitchVariant = RedscateSwitchVariant.Standard,
    leftIcon: (@Composable () -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null
) {
    val tokens = RedscateThemeTokens.current
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(tokens.shapes.pillRadius))
            .background(tokens.colors.background)
            .border(2.dp, tokens.colors.outline, RoundedCornerShape(tokens.shapes.pillRadius))
            .height(44.dp)
            .width(92.dp)
            .padding(horizontal = 2.dp)
            .alpha(if (enabled) 1f else 0.55f)
            .clickable(enabled = enabled) { onCheckedChange(!checked) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val leftSelected = !checked
        SwitchSlot(
            selected = leftSelected,
            selectedColor = if (variant == RedscateSwitchVariant.LeftAccent) tokens.colors.primary else tokens.colors.onSurface,
            isLeft = true,
            content = leftIcon
        )
        SwitchSlot(
            selected = checked,
            selectedColor = tokens.colors.onSurface,
            isLeft = false,
            content = rightIcon
        )
    }
}

@Composable
private fun SwitchSlot(
    selected: Boolean,
    selectedColor: Color,
    isLeft: Boolean,
    content: (@Composable () -> Unit)?
) {
    val tokens = RedscateThemeTokens.current
    Box(
        modifier = Modifier
            .padding(horizontal = 1.dp)
            .size(38.dp)
            .clip(CircleShape)
            .background(if (selected) selectedColor else tokens.colors.background),
        contentAlignment = Alignment.Center
    ) {
        if (content != null) {
            content()
        } else {
            Icon(
                painter = painterResource(id = if (isLeft) R.drawable.ic_switch_sun else R.drawable.ic_switch_moon),
                contentDescription = if (isLeft) "sun" else "moon",
                tint = if (selected) tokens.colors.background else tokens.colors.onSurface,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

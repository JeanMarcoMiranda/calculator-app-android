package com.jacketmll.calculator.ui.calculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.jacketmll.calculator.ui.theme.ButtonDarkGray
import com.jacketmll.calculator.ui.theme.TextWhite

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    color: Color = ButtonDarkGray,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .clickable { onClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 36.sp,
            color = TextWhite
        )
    }

}
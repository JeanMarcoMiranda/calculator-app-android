package com.jacketmll.calculator.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jacketmll.calculator.ui.calculator.components.CalculatorButton
import com.jacketmll.calculator.ui.theme.AccentOrange
import com.jacketmll.calculator.ui.theme.TextWhite

@Composable
fun CalculatorScreen(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Área de Texto (Display)
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = TextWhite,
                maxLines = 2
            )

            // Fila de botones (Ejemplo de una fila)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier.aspectRatio(2f).weight(2f),
                    color = LightGray,
                    onClick = { onAction(CalculatorAction.Clear) }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    color = LightGray,
                    onClick = { onAction(CalculatorAction.Delete) }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier.aspectRatio(1f).weight(1f),
                    color = AccentOrange,
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) }
                )
            }

            // Fila 7, 8, 9, x
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "7", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(7)) })
                CalculatorButton(symbol = "8", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(8)) })
                CalculatorButton(symbol = "9", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(9)) })
                CalculatorButton(symbol = "x", modifier = Modifier.aspectRatio(1f).weight(1f), color = AccentOrange, onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) })
            }
// Fila 4, 5, 6, -
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "4", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(4)) })
                CalculatorButton(symbol = "5", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(5)) })
                CalculatorButton(symbol = "6", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(6)) })
                CalculatorButton(symbol = "-", modifier = Modifier.aspectRatio(1f).weight(1f), color = AccentOrange, onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) })
            }
// Fila 1, 2, 3, +
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "1", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(1)) })
                CalculatorButton(symbol = "2", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(2)) })
                CalculatorButton(symbol = "3", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Number(3)) })
                CalculatorButton(symbol = "+", modifier = Modifier.aspectRatio(1f).weight(1f), color = AccentOrange, onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) })
            }
// Fila 0, Decimal, =
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                CalculatorButton(symbol = "0", modifier = Modifier.aspectRatio(2f).weight(2f), onClick = { onAction(CalculatorAction.Number(0)) })
                CalculatorButton(symbol = ".", modifier = Modifier.aspectRatio(1f).weight(1f), onClick = { onAction(CalculatorAction.Decimal) })
                CalculatorButton(symbol = "=", modifier = Modifier.aspectRatio(1f).weight(1f), color = AccentOrange, onClick = { onAction(CalculatorAction.Calculate) })
            }
        }
    }
}
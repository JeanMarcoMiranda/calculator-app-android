package com.jacketmll.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacketmll.calculator.ui.calculator.CalculatorScreen
import com.jacketmll.calculator.ui.calculator.CalculatorViewModel
import com.jacketmll.calculator.ui.theme.BackgroundBlack
import com.jacketmll.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                val state = viewModel.state
                val buttonSpacing = 8.dp

                CalculatorScreen(
                    state = state,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundBlack)
                        .padding(16.dp)
                )
            }
        }
    }
}

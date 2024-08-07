package com.example.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                // 메인 UI 컴포저블
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen() {
    // 상태 변수 초기화
    var count by remember { mutableStateOf(0) }

    // 레이아웃 구성
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Count: $count")
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = { count++ }) {
                    Text(text = "+")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { count-- }) {
                    Text(text = "-")
                }
            }
        }
    }
}

@Composable
fun DefaultPreview() {
    ButtonTheme {
        CounterScreen()
    }
}

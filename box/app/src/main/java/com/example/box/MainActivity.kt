package com.example.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.box.ui.theme.BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LayoutDemo()
                }
            }
        }
    }
}

@Composable
fun LayoutDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly, // 항목들 사이에 고르게 공간 배치
        horizontalAlignment = Alignment.CenterHorizontally // Column 내 항목을 수평으로 중앙 정렬
    ) {
        // Box를 사용하여 겹쳐서 배치하기
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center // Box 내 내용 중앙 정렬
        ) {
            Text(text = "Box", color = Color.White)
        }

        // Column을 사용하여 수직으로 배치하기
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Item 1", modifier = Modifier.background(Color.Blue).padding(8.dp), color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Item 2", modifier = Modifier.background(Color.Green).padding(8.dp), color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Item 3", modifier = Modifier.background(Color.Red).padding(8.dp), color = Color.White)
        }

        // Row를 사용하여 수평으로 배치하기
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, // 항목들 사이에 고르게 공간 배치
            verticalAlignment = Alignment.CenterVertically // Row 내 항목을 수직으로 중앙 정렬
        ) {
            Text(text = "Row 1", modifier = Modifier.background(Color.Cyan).padding(8.dp), color = Color.Black)
            Text(text = "Row 2", modifier = Modifier.background(Color.Magenta).padding(8.dp), color = Color.Black)
            Text(text = "Row 3", modifier = Modifier.background(Color.Yellow).padding(8.dp), color = Color.Black)
        }
    }
}

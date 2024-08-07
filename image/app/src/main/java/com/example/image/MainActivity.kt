package com.example.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                // 메인 UI 컴포저블
                ImageTextFieldScreen()
            }
        }
    }
}

// UI 컴포저블을 정의하는 함수
@Composable
fun ImageTextFieldScreen() {
    // 상태 변수 초기화
    var text by remember { mutableStateOf("") } // text 상태 변수를 선언하고 초기값을 빈 문자열로 설정

    // 레이아웃 구성
    Column(
        modifier = Modifier
            .fillMaxSize() // 화면 전체 크기로 설정
            .padding(16.dp), // 16dp의 패딩 적용
        horizontalAlignment = Alignment.CenterHorizontally, // 수평 중앙 정렬
        verticalArrangement = Arrangement.Center // 수직 중앙 정렬
    ) {
        TextField(
            value = text, // 현재 상태 변수 text의 값을 표시
            onValueChange = { newText -> text = newText }, // 텍스트가 변경될 때 상태 변수 text 업데이트
            label = { Text("Enter text") }, // TextField의 레이블 설정
            modifier = Modifier.fillMaxWidth(), // 부모의 전체 너비로 설정
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done) // 키보드 옵션 설정
        )

        Spacer(modifier = Modifier.height(16.dp)) // 16dp의 공간 추가

        Box(
            contentAlignment = Alignment.Center, // Box 내부의 내용 중앙 정렬
            modifier = Modifier
                .size(200.dp) // Box 크기 설정
                .padding(16.dp) // 16dp의 패딩 적용
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunrin_logo), // 이미지 리소스를 로드
                contentDescription = "Sunrin Logo", // 이미지 설명 설정
                contentScale = ContentScale.Crop, // 이미지 크기 조정
                modifier = Modifier.fillMaxSize() // 이미지 크기를 Box 크기에 맞춤
            )
            Text(
                text = text, // 현재 상태 변수 text의 값을 표시
                color = Color.Black, // 텍스트 색상 설정
                modifier = Modifier.align(Alignment.Center) // 텍스트를 Box의 중앙에 정렬
            )
        }
    }
}


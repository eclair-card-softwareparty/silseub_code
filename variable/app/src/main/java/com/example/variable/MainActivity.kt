package com.example.variable

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        main()
    }

    fun main() {
        // val: 불변 변수, 초기값을 할당하면 이후에 변경할 수 없음
        val immutableValue = 10
        println("Initial immutableValue: $immutableValue")

        // 다음 줄을 주석 해제하면 컴파일 오류가 발생합니다.
        // immutableValue = 20 // Error: Val cannot be reassigned

        // var: 가변 변수, 초기값을 할당한 후에도 변경 가능
        var mutableValue = 10
        println("Initial mutableValue: $mutableValue")

        // mutableValue의 값을 변경
        mutableValue = 20
        println("Updated mutableValue: $mutableValue")
    }
}

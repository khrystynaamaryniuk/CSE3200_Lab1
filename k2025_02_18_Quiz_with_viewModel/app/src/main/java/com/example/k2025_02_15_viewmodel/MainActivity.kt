package com.example.k2025_02_15_viewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.k2025_02_15_viewmodel.views.BooleanQuestionScreen

import com.example.k2025_02_15_viewmodel.views.ui.theme.BooleanQuestionsAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooleanQuestionsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Column {
                        BooleanQuestionScreen(this@MainActivity)
                    }
                }
            }
        }

    }
}


package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                ProfileScreen()
            }
        }
    }
}

@Preview(
    name = "Light",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfileScreenLight() {
    MyApplicationTheme(darkTheme = false) {
        ProfileScreen()
    }
}

@Preview(
    name = "Dark",
    showBackground = true,
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfileScreenDark() {
    MyApplicationTheme(darkTheme = true) {
        ProfileScreen()
    }
}
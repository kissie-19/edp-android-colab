package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) { BusinessCard() }
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val darkMode = isSystemInDarkTheme()
    val backgroundColor = if (darkMode) Color(0xFF121212) else Color(0xFFF4F2F1)
    val cardColor = if (darkMode) Color(0xFF2A1B3D) else Color(0xFFEDE0FF)
    val primaryText = if (darkMode) Color.White else Color(0xFF771C1B)
    val secondaryText = if (darkMode) Color.LightGray else Color.DarkGray

    Box(modifier = Modifier.fillMaxSize().background(backgroundColor), contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier.fillMaxWidth(0.85f).padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = cardColor)
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(R.drawable.kisi),
                    contentDescription = "Profile photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(200.dp).clip(CircleShape).border(2.dp, primaryText, CircleShape)
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(text = "KISSIE ANN APPLE APUT", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = primaryText, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "BSIT | STUDENT", fontSize = 16.sp, color = secondaryText)
                Spacer(modifier = Modifier.height(25.dp))
                ContactRow(icon = Icons.Default.Phone, label = "+63 936 200 8050", textColor = secondaryText)
                ContactRow(icon = Icons.Default.Email, label = "kaaput42160@liceo.edu.ph", textColor = secondaryText)
            }
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, label: String, textColor: Color) {
    Row(modifier = Modifier.padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null, tint = Color(0xFF771C1B))
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = label, color = textColor, fontSize = 14.sp)
    }
}

@Preview(name = "Business Card Preview", showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun BusinessCardPreview() { BusinessCard() }

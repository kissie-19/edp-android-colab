    package com.example.myapplication

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Add
    import androidx.compose.material3.Button
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.FloatingActionButton
    import androidx.compose.material3.Icon
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.OutlinedButton
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import com.example.myapplication.ui.theme.MyApplicationTheme

    class MainActivity : ComponentActivity() {
        @OptIn(ExperimentalMaterial3Api::class)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                MyApplicationTheme {
                    Scaffold(
                        topBar = { TopAppBar(title = { Text("My Profile") }, /* icons */) },
                        floatingActionButton = { FloatingActionButton(onClick = {}) {
                            Icon(Icons.Default.Add, contentDescription = "Add") } }
                    ) { padding ->
                        Column(
                            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Box { /* avatar + Badge aligned BottomEnd */ }
                            Text("Ada Lovelace", style = MaterialTheme.typography.headlineSmall)
                            Text("Android Developer",
                                color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Row(Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(onClick = {}, modifier = Modifier.weight(1f)) { Text("Message") }
                                OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) { Text("Follow") }
                            }

                        }
                    }
                    }
                }
            }
        }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            Greeting("Android")
        }
    }

    @Composable
    fun Greeting(x0: String) {
        TODO("Not yet implemented")
    }
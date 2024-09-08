package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {


    private lateinit var networkMonitor: NetworkCheck

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Hello, Compose!")
                Button(onClick = { /* Handle button click */ }) {
                    Text("Click me")
                }
            }
        }

        networkMonitor = NetworkCheck(this)

        networkMonitor.startNetworkCallback()
    }


    override fun onDestroy() {
        super.onDestroy()

        networkMonitor.stopNetworkCallback()

    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ConnectivityStatusText(isOnline: Boolean) {
    val statusText = if (isOnline) "Online" else "Offline"
    Text(text = "Status: $statusText")
}




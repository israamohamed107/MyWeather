package com.israa.myweather

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.israa.myweather.ui.theme.MyWeatherTheme
import com.israa.myweather.ui.weather.WeatherScreen

class MainActivity : ComponentActivity() {

    private lateinit var requestPermissionLauncher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyWeatherTheme {
                var hasPermission by remember { mutableStateOf(checkPermissions()) }

                if (hasPermission) {
                    WeatherScreen()
                } else {
                    val context = LocalContext.current

                    // Register the permission launcher inside the Composable scope
                    val launcher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.RequestMultiplePermissions()
                    ) { permissions ->
                        val fineLocationGranted =
                            permissions[android.Manifest.permission.ACCESS_FINE_LOCATION] == true
                        val coarseLocationGranted =
                            permissions[android.Manifest.permission.ACCESS_COARSE_LOCATION] == true

                        if (fineLocationGranted && coarseLocationGranted) {
                            hasPermission = true
                            Toast.makeText(context, "Location Permission Granted", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Location Permission Denied", Toast.LENGTH_SHORT).show()
                        }
                    }

                    // Request permissions automatically when screen is displayed
                    LaunchedEffect(Unit) {
                        launcher.launch(
                            arrayOf(
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    }
                }
            }
        }
    }

    private fun checkPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWeatherTheme {
    }
}
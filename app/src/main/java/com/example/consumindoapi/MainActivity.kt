package com.example.consumindoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.consumindoapi.ui.theme.ConsumindoAPITheme
import androidx.lifecycle.lifecycleScope
import com.example.consumindoapi.network.RetrofitClient
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsumindoAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Clique abaixo para buscar o usuário")

        Button(onClick = {
            scope.launch {
                try {
                    val response = RetrofitClient.apiService.getUser(7)
                    if (response.isSuccessful) {
                        val user = response.body()
                        println("Usuário encontrado: ${user?.name}")
                    } else {
                        println("Erro na API: ${response.code()}")
                    }
                } catch (e: Exception) {
                    println("Falha na rede: ${e.message}")
                }
            }
        }) {
            Text(text = "Buscar Usuário")
        }
    }


}




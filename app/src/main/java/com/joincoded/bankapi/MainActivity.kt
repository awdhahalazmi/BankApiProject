package com.joincoded.bankapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joincoded.bankapi.NavHomeScreen.NavScreen

import com.joincoded.bankapi.ui.theme.BankApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val viewModel: BankViewModel = viewModel()
//                    viewModel.application = application
//                    viewModel.signup("awdhah","123","")
//                    print(viewModel.token)
//                    viewModel.login("awdhah","123")
                    //viewModel.getAccountInfo()
                    //print(viewModel.currentUser?.username)

//                    Column {
//
//
//                        Button(onClick = {
//                            viewModel.login("Omar", "12345")
//                        }) {
//
//                        }
//                        Button(onClick = {
//                            viewModel.withdraw(20.0)
//                            viewModel.getAccountInfo()
//                        }) {
//
//                        }
//                        Greeting(name = "${viewModel.token?.getBearerToken()}")
                    //SignUpScreen(viewModel)
                    //WelcomeScreen()
                    //SignUpScreen()
                    NavScreen()
                    }

                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankApiTheme {
        Greeting("Android")
    }
}
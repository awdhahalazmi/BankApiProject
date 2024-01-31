package com.joincoded.bankapi.composableApi

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.R
import com.joincoded.bankapi.ui.theme.kfhColor
import com.joincoded.bankapi.viewModel.BankViewModel

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun AppContent() {
//
//    val navController = rememberNavController()
//
//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(onClick = { navController.navigate("signupRoute")}) {
//                Text("SignUP")
//
//            }
//        }
//    ) {
//
//        NavHost(navController = navController, startDestination = "welcomeScreen") {
//            composable("welcomeScreen") {
//
//                WelcomeScreen()
//
//            }
//            composable("signupRoute") {
//
//                SignUpScreen()
//
//            }
//        }
//
//    }
//
//}




@Composable
fun WelcomeScreen(navController: NavController,viewModel: BankViewModel = viewModel()) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val navController = rememberNavController()


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.kfh),

            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.Fit
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(21.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to KFH !",
            fontSize = 25.sp
            , fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier){
            Text(text="Login to your account ", textAlign = TextAlign.Left,
                fontSize = 21.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter Username") }
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier
            .height(25.dp)
            .padding(40.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),


            ) {
            Button( colors = ButtonDefaults.buttonColors(containerColor = kfhColor)
                , onClick = {

                    viewModel.login(username, password)
                } , shape = RoundedCornerShape(30)) {
                Text("Log In",

                    modifier = Modifier
                        .width(150.dp)
                        .height(30.dp),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(100.dp))

            OutlinedButton( colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = {

                    navController.navigate("signupRoute")
                    viewModel.signup(username, password)
            }, shape = RoundedCornerShape(30)) {
                Text("Sign Up", modifier = Modifier
                    .width(150.dp)
                    .height(30.dp),
                    color = kfhColor,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)
            }
        }

    }

}

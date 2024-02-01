package com.joincoded.bankapi.composableApi

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.R
import com.joincoded.bankapi.ui.theme.kfhColor
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.utils.Routes.Companion.loginRoute
import com.joincoded.bankapi.viewModel.BankViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    viewModel: BankViewModel = viewModel(),
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        "Sign Up",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.DarkGray, textAlign = TextAlign.Center,
                        fontSize = 32.sp,
                    )

                })
            }

        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo),

                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(MaterialTheme.shapes.large),
                    contentScale = ContentScale.Fit
                )

                Row(modifier = Modifier) {
                    Text(
                        text = "Sign up to your Account ", textAlign = TextAlign.Left,
                        fontSize = 21.sp
                    )
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
                Spacer(
                    modifier = Modifier
                        .height(25.dp)
                        .padding(40.dp)
                )

                TextField(
                    value = image,
                    onValueChange = { image = it },
                    label = { Text("Enter image") },

                    )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Button(
                        modifier = Modifier.padding(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = kfhColor),
                        onClick = {
                            viewModel.signup(username, password, "")
                        },
                        shape = RoundedCornerShape(30)
                    ) {
                        Text(
                            "Sign Up ",

                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }


                }
            }
        }
    }
}
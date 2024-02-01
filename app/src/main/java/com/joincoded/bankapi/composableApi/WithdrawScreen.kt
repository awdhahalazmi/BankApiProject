package com.joincoded.bankapi.composableApi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.R
import com.joincoded.bankapi.ui.theme.kfhColor
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.utils.Routes.Companion.withdrawRoute
import com.joincoded.bankapi.viewModel.BankViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithdrawScreen(navController: NavController = rememberNavController(),
                   viewModel: BankViewModel = viewModel()) {
    var username by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf(0.0) }
    var balance by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        "Withdraw",
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



                Text(
                    modifier = Modifier.padding(6.dp),
                    text = "Enter the amount:  ",
                    textAlign = TextAlign.Justify,
                    fontSize = 25.sp
                )

                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = amount.toString(),
                    onValueChange = { amount = it.toDouble() },
                    label = { Text("Enter amount") }
                )

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    onClick = {
                        viewModel.withdraw(amount = amount)

                    },
                    shape = RoundedCornerShape(30)
                ) {

                    Text(
                        "Withdraw",

                        modifier = Modifier
                            .width(140.dp)
                            .height(30.dp),
                        color = kfhColor,
                        textAlign = TextAlign.Center,
                        fontSize = 23.sp
                    )

                }


            }
        }
    }
}
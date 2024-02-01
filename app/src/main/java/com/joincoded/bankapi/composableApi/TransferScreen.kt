package com.joincoded.bankapi.composableApi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.joincoded.bankapi.viewModel.BankViewModel
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransferScreen(navController: NavController = rememberNavController(),
                   viewModel: BankViewModel = viewModel() ) {
    var username by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var balance by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var purposes : String


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "Transfer",
                        fontWeight = FontWeight.Bold,
                        color = kfhColor,
                        fontSize = 24.sp)

                })
            }

        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = kfhColor),

                    modifier = Modifier
                        .padding(padding)
                        .align(Alignment.CenterHorizontally)
                        .width(350.dp)
                        .height(100.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Reciver :", fontSize = 21.sp, color = Color.White
                        )

                        TextField(modifier = Modifier.width(200.dp),
                            value = id,
                            onValueChange = { id = it },
                            label = { Text("Enter id") }
                        )
                    }
                }
                OutlinedCard(
                    colors = CardDefaults.cardColors(containerColor = kfhColor),
                    modifier = Modifier
                        .padding(padding)
                        .align(Alignment.CenterHorizontally)
                        .width(350.dp)
                        .height(100.dp)

                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = "Amount:", fontSize = 21.sp, color = Color.White
                        )

                        TextField(modifier = Modifier.width(200.dp),
                            value = amount,
                            onValueChange = { amount = it },
                            label = { Text("0.0") }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))

                OutlinedButton(
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    onClick = {

                        //BUTTON TRANSFER
                    },
                    shape = RoundedCornerShape(30)
                ) {

                    Text(
                        "Transfer",

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





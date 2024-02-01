package com.joincoded.bankapi.composableApi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.R
import com.joincoded.bankapi.ui.theme.kfhColor
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.utils.Routes.Companion.depositRoute
import com.joincoded.bankapi.utils.Routes.Companion.trasferRoute
import com.joincoded.bankapi.viewModel.BankViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankMainScreen(
    navController: NavController = rememberNavController(),
    viewModel: BankViewModel = viewModel(),
) {


    var profileImage = painterResource(id = R.drawable.profile)

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(trasferRoute) }) {
                Image(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp),
                    painter = painterResource(id = R.drawable.transfer),
                    contentDescription = null
                )
                //   Text("Transfer", fontWeight = FontWeight.SemiBold)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.End)
                    .height(100.dp)
                    .width(100.dp)
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Welcome! ", fontSize = 27.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                // Profile picture at the corner
                Image(
                    painter = profileImage,
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(90.dp)
                        .clip(CircleShape)
                        .padding(top = 10.dp)
                )

                Text(
                    modifier = Modifier.padding(top = 30.dp),
                    text = "${viewModel.currentUser?.username}", textAlign = TextAlign.Left,
                    fontSize = 25.sp
                )

            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.padding(start = 55.dp, top = 0.dp),
                    textAlign = TextAlign.Left,
                    text = "Balance: ${viewModel.currentUser?.balance}",
                    fontSize = 30.sp,
                    color = kfhColor,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    horizontalArrangement = Arrangement.Absolute.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .height(80.dp)
                            .width(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        onClick = {
                            navController.navigate(depositRoute)

                            viewModel.deposit(0.0)
                        },
                        shape = RoundedCornerShape(50)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.deposit),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .width(100.dp)
                    )

                    OutlinedButton(
                        modifier = Modifier
                            .height(80.dp)
                            .width(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        onClick = {
                            navController.navigate(Routes.withdrawRoute)

                            viewModel.withdraw(0.0)
                        },
                        shape = RoundedCornerShape(50)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.withdraw),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )

                    }


                }

            }

            Spacer(modifier = Modifier.height(30.dp))
            LazyRow(
                modifier = Modifier
                    .width(400.dp)
                    .height(200.dp)
                    .padding(bottom = 15.dp),
                verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End
            ) {
                item {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp)).fillMaxWidth(),
                        painter = painterResource(id = R.drawable.img_1168),
                        contentDescription = null,
                        contentScale = ContentScale.Fit


                    )
                }


                item {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp)),
                        painter = painterResource(id = R.drawable.img_1169),
                        contentDescription = null,

                        contentScale = ContentScale.Fit
                    )
                }
                item {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp)),
                        painter = painterResource(id = R.drawable.img_1170),
                        contentDescription = null,
                        contentScale = ContentScale.Fit


                    )
                }


                item {
                    Image(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp)),
                        painter = painterResource(id = R.drawable.offerr),
                        contentDescription = null,

                        contentScale = ContentScale.Fit
                    )
                    //TrasactionsList(viewModel)
                }


            }

        }
    }
}






package com.joincoded.bankapi.composableApi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joincoded.bankapi.viewModel.BankViewModel

@Composable
fun TrasactionsList(viewModel: BankViewModel = viewModel() ) {
    LazyColumn {

        items(viewModel.transactions) {
            Card(
                modifier = androidx.compose.ui.Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                ,
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),

                ) {
            }
        }
    }
}
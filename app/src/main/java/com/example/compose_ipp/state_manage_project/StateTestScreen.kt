package com.example.compose_ipp.state_manage_project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

//remember => persist state on recomposition
//rememberSaveable -> persist even on configuration changes
//ViewModel and Livedata -> Hoist the state for re-usability

@Composable
fun StateTestScreen(viewModel: StateTestViewModel){
    //상태 저장
    val name by viewModel.name.observeAsState(initial =  "")
    val surname by viewModel.surname.observeAsState(initial = "")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText("$name $surname")
        MyTextField(name, onNameChange = {
            viewModel.onNameUpdate(it)
        })
        MyTextField(surname, onNameChange = {
            viewModel.onSurNameUpdate(it)
        })
    }
}

@Composable
fun MyText(name : String){
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name : String, onNameChange: (String) -> Unit){
    OutlinedTextField (
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = { Text(text = "Enter name") }
    )
}
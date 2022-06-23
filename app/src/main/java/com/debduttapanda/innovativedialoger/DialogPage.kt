package com.debduttapanda.innovativedialoger

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DialogPage(
    vm: MyViewModel = viewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {
            vm.showDialog1()
        }) {
            Text("Show dialog")
        }
    }
    if(vm.isDialogOpen.value){
        Dialog(
            onDismissRequest = {
                vm.dismissDialog()
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ){
                    Text("Heading")
                    Divider()
                    Text("Message?")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        TextButton(onClick = {
                            vm.onPositive()
                        }) {
                            Text("Positive")
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        TextButton(onClick = {
                            vm.onNegative()
                        }) {
                            Text("Negative")
                        }
                    }
                }
            }
        }
    }

    if(vm.dialoger.enabled.value){
        Dialog(
            onDismissRequest = {
                vm.dialoger.onDone("dismiss")
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ){
                    Text("Heading")
                    Divider()
                    Text("Message?")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        TextButton(onClick = {
                            vm.dialoger.onDone("positive")
                        }) {
                            Text("Positive")
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        TextButton(onClick = {
                            vm.dialoger.onDone("negative")
                        }) {
                            Text(vm.negativeText.value)
                        }
                    }
                }
            }
        }
    }
}
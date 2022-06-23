package com.debduttapanda.innovativedialoger

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    val isDialogOpen = mutableStateOf(false)
    fun showDialog() {
        isDialogOpen.value = true
    }

    fun dismissDialog() {
        isDialogOpen.value = false
    }

    fun onPositive() {
        isDialogOpen.value = false
        //do the other stuffs
    }

    fun onNegative() {
        isDialogOpen.value = false
        //do the other stuffs
    }

    /////////////////////////////
    val negativeText = mutableStateOf("Negative")
    val dialoger = Dialoger()

    fun showDialog1() {
        viewModelScope.launch {
            val result = dialoger.show{
                if(it=="negative"){
                    negativeText.value = (System.currentTimeMillis()%4).toString()
                    false
                }
                else{
                    true
                }
            }
            Log.d("my_result","$result")
        }
    }
}
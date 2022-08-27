package com.speda.HelloCompose
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Random


class MainViewModel: ViewModel() {
    private val _counter = mutableStateOf(value = 0)
    val counter : State<Int> = _counter
    val random = Random()

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    fun onAdd(){
        _counter.value = _counter.value + 1
    }

    fun onReset(){
        _counter.value = 0
    }

    fun onRandomNumber(){
        _counter.value = rand(1, 10000)
    }

}
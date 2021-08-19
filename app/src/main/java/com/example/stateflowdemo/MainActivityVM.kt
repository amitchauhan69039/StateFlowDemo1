package com.example.stateflowdemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

class MainActivityVM : ViewModel() {
    private val _countState = MutableStateFlow(0)

    private val _countShared = MutableStateFlow(0)

    val countState: StateFlow<Int> = _countState

    val countShared: SharedFlow<Int> = _countShared.asSharedFlow()

    fun incrementCount() {
        _countState.value++
    }

    fun decrementCount() {
        _countState.value--
    }

    fun incrementSharedCount() {
        _countShared.value++
    }

    fun decrementSharedCount() {
        _countShared.value--
    }
}
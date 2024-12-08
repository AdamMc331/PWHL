package com.pwhl.mobile.shared.gamedetail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameDetailViewModel(
    gameId: String,
) : ViewModel() {
    private val mutableState = MutableStateFlow(GameDetailState.Default)
    val state = mutableState.asStateFlow()

    init {
        println("ADAMLOG - CREATING WITH ID: $gameId")
    }
}

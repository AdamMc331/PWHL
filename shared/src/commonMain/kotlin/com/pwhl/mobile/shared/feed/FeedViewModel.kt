package com.pwhl.mobile.shared.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pwhl.mobile.shared.domain.usecases.FetchRecentGamesUseCase
import kotlinx.coroutines.launch

class FeedViewModel(
    private val recentGamesUseCase: FetchRecentGamesUseCase,
) : ViewModel() {
    fun fetchData() {
        viewModelScope.launch {
            val x = recentGamesUseCase.invoke()
            println("ADAMLOG - $x")
        }
    }
}

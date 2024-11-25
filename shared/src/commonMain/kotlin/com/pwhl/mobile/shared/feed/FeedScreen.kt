package com.pwhl.mobile.shared.feed

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: FeedViewModel = koinViewModel()
    viewModel.fetchData()
}

@file:Suppress("UndocumentedPublicClass")

package com.adammcneilly.pwhl.mobile.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.SportsHockey
import androidx.compose.ui.graphics.vector.ImageVector
import com.adammcneilly.pwhl.mobile.shared.feed.FeedScreen
import com.adammcneilly.pwhl.mobile.shared.news.NewsScreen
import com.adammcneilly.pwhl.mobile.shared.profile.ProfileScreen
import com.adammcneilly.pwhl.mobile.shared.standings.StandingsScreen
import kotlinx.serialization.Serializable

/**
 * An enumeration of tabs that will appear as navigation items
 * on the home screen of the application.
 */
@Serializable
sealed class HomeTab<T>(
    val route: T,
) {
    @Serializable
    data object Feed : HomeTab<FeedScreen>(FeedScreen)

    @Serializable
    data object News : HomeTab<NewsScreen>(NewsScreen)

    @Serializable
    data object Standings : HomeTab<StandingsScreen>(StandingsScreen)

    @Serializable
    data object Profile : HomeTab<ProfileScreen>(ProfileScreen)

    fun getTitle(): String {
        return when (this) {
            Feed -> "Feed"
            News -> "News"
            Standings -> "Standings"
            Profile -> "Profile"
        }
    }

    fun getIcon(): ImageVector {
        return when (this) {
            Feed -> Icons.Default.SportsHockey
            News -> Icons.Default.Newspaper
            Standings -> Icons.Default.BarChart
            Profile -> Icons.Default.AccountCircle
        }
    }
}

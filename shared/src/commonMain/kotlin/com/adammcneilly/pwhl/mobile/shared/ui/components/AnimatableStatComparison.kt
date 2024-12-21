package com.adammcneilly.pwhl.mobile.shared.ui.components

import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.animateTo
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.displaymodels.StatComparisonDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.modifiers.whenInView
import kotlinx.coroutines.launch

/**
 * Shows the comparison between [leftValue] and [rightValue] by drawing lines on a canvas.
 */
@Composable
fun AnimatableStatComparison(
    statComparison: StatComparisonDisplayModel,
    modifier: Modifier = Modifier,
    initialAnimationPercentage: Float = 0F,
) {
    val animationPercentage = remember {
        AnimationState(initialAnimationPercentage)
    }

    val coroutineScope = rememberCoroutineScope()

    StatComparison(
        statComparison = statComparison,
        percentageToRender = animationPercentage.value,
        modifier = modifier
            .whenInView {
                coroutineScope.launch {
                    animationPercentage.animateTo(
                        targetValue = 1F,
                        animationSpec = tween(
                            durationMillis = 1000,
                        ),
                    )
                }
            },
    )
}

package com.adammcneilly.pwhl.mobile.shared.util

import app.cash.burst.Burst
import com.varabyte.truthish.assertThat
import kotlin.test.Test

@Burst
class NumberFormatterTest(
    private val testInput: TestInput,
) {
    private val numberFormatter = numberFormatter()

    @Test
    fun formatFloatTwoDecimalPlaces() {
        val output = numberFormatter.formatFloatTwoDecimalPlaces(
            value = testInput.input,
        )

        assertThat(output).isEqualTo(testInput.expectedOutput)
    }

    enum class TestInput(
        val input: Float,
        val expectedOutput: String,
    ) {
        Integer(
            input = 1F,
            expectedOutput = "1.00",
        ),
        SingleDecimal(
            input = 1.2F,
            expectedOutput = "1.20",
        ),
        DoubleDecimal(
            input = 1.23F,
            expectedOutput = "1.23",
        ),
        TripleDecimal(
            input = 1.234F,
            expectedOutput = "1.23",
        ),
    }
}

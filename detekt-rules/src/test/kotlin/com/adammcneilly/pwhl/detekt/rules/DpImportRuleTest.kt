package com.adammcneilly.pwhl.detekt.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.test.assertThat
import io.gitlab.arturbosch.detekt.test.lint
import kotlin.test.Test

class DpImportRuleTest {
    private val subject = DpImportRule(Config.empty)

    @Test
    fun `fail file with dp import`() {
        val findings = subject.lint(codeWithImport)
        assertThat(findings).hasSize(1)
    }

    @Test
    fun `pass file without dp import`() {
        val findings = subject.lint(codeWithoutImport)
        assertThat(findings).hasSize(0)
    }
}

private val codeWithImport: String = """
    import androidx.compose.ui.unit.dp
    
    val myWidth = 1.dp
""".trimIndent()

private val codeWithoutImport: String = """
    val myWidth = PWHLTheme.dimensions.itemWidth
""".trimIndent()

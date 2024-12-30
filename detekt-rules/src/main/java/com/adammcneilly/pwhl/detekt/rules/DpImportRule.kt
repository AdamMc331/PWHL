package com.adammcneilly.pwhl.detekt.rules

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtImportDirective

class DpImportRule(
    config: Config,
) : Rule(config) {
    override val issue = Issue(
        id = javaClass.simpleName,
        severity = Severity.CodeSmell,
        description = "Importing androidx.compose.ui.unit.dp directly is discouraged. " +
            "Use dimensions from the Material theme instead.",
        debt = Debt.FIVE_MINS,
    )

    override fun visitImportDirective(
        importDirective: KtImportDirective,
    ) {
        println("ADAMLOG - visitImportDirective")
        report(CodeSmell(issue, Entity.from(importDirective), issue.description))
        if (importDirective.importedFqName?.asString() == "androidx.compose.ui.unit.dp") {
            report(CodeSmell(issue, Entity.from(importDirective), issue.description))
        }
        super.visitImportDirective(importDirective)
    }
}

package com.adammcneilly.pwhl.detekt.rules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class RuleProvider : RuleSetProvider {
    override val ruleSetId: String = "pwhl-rules"

    override fun instance(
        config: Config,
    ): RuleSet {
        return RuleSet(
            id = ruleSetId,
            rules = listOf(
                DpImportRule(config),
            ),
        )
    }
}

package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Clojure : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Clojure"

    override fun getYear(): Int = 2007

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.Functional,
        Paradigm.Concurrent,
        Paradigm.AgentOriented,
        Paradigm.Logic,
        Paradigm.Macro,
        Paradigm.Pipeline
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            append("(")
            appendWithColor(string = "println ", color = primaryColor)
            appendWithColor(string = "\"Hello, World!\"", color = secondaryVariantColor)
            append(")")
        }
    }
}

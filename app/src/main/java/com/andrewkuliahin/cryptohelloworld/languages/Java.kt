package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import com.andrewkuliahin.cryptohelloworld.tab
import kotlinx.parcelize.Parcelize

@Parcelize
object Java : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 14.sp

    override fun getName(): String = "Java"

    override fun getYear(): Int = 1995

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.ObjectOriented,
        Paradigm.Generic,
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.Reflective,
        Paradigm.Concurrent
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "class ", color = primaryColor)
            appendWithColor(string = "Main ", color = primaryVariantColor)
            append(" {\n")
            appendWithColor(string = "${tab}public static ", color = primaryColor)
            appendWithColor(string = "void ", color = secondaryVariantColor)
            appendWithColor(string = "main", color = primaryVariantColor)
            append("(String[] args) {\n")
            append("$tab${tab}System.")
            appendWithColor(string = "out", color = secondaryVariantColor)
            append(".")
            appendWithColor(string = "println", color = secondaryVariantColor)
            append("(")
            appendWithColor(string = "\"Hello, World!\"", color = primaryColor)
            append(");\n")
            append("$tab}\n")
            append("}")
        }
    }
}

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
object Kotlin : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Kotlin"

    override fun getYear(): Int = 2011

    override fun getParadigms(): List<Paradigm> = listOf(
        Paradigm.ObjectOriented,
        Paradigm.Functional,
        Paradigm.Imperative,
        Paradigm.BlockStructured,
        Paradigm.Declarative,
        Paradigm.Generic,
        Paradigm.Reflective,
        Paradigm.Concurrent
    )

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "fun ", color = primaryColor)
            appendWithColor(string = "main", color = secondaryColor)
            append("() {\n")
            appendWithColor(string = "${tab}println", color = secondaryVariantColor)
            append("(")
            appendWithColor(string = "\"Hello, World!\"", color = primaryVariantColor)
            append(")\n")
            append("}")
        }
    }
}

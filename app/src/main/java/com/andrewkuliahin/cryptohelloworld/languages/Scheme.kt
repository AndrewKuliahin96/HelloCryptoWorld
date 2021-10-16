package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object Scheme : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Scheme"

    override fun getYear(): Int = 1975

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Functional, Paradigm.Imperative, Paradigm.Meta)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            append("(")
            appendWithColor(string = "display ", color = primaryColor)
            appendWithColor(string = "\"Hello, world!\"", color = secondaryVariantColor)
            append(") (")
            appendWithColor(string = "newline", color = secondaryColor)
            append(")")
        }
    }
}

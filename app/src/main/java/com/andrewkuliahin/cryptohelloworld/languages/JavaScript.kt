package com.andrewkuliahin.cryptohelloworld.languages

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.andrewkuliahin.cryptohelloworld.appendWithColor
import com.andrewkuliahin.cryptohelloworld.languages.paradigm.Paradigm
import kotlinx.parcelize.Parcelize

@Parcelize
object JavaScript : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "JavaScript"

    override fun getYear(): Int = 1995

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Functional, Paradigm.Imperative, Paradigm.EventDriven)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "console", color = primaryColor)
            append(".")
            appendWithColor(string = "log", color = primaryColor)
            append("(")
            appendWithColor(string = "\"Hello, World!\"", color = secondaryVariantColor)
            append(");")
        }
    }
}

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
object Cobol : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 20.sp

    override fun getName(): String = "COBOL"

    override fun getYear(): Int = 1959

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Procedural, Paradigm.Imperative, Paradigm.ObjectOriented)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "IDENTIFICATION DIVISION", color = primaryColor)
            append(".\n")
            appendWithColor(string = "PROGRAM-ID", color = primaryColor)
            append(". ")
            append("HELLO-WORLD")
            append(".\n")
            appendWithColor(string = "PROCEDURE DIVISION", color = primaryColor)
            append(".\n")
            appendWithColor(string = "${tab}DISPLAY ", color = primaryColor)
            appendWithColor(string = "\"Hello, World!\"", color = secondaryVariantColor)
            append(".\n")
            appendWithColor(string = "${tab}STOP ", color = primaryColor)
            appendWithColor(string = "RUN", color = primaryVariantColor)
            append(".")
        }
    }
}

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
object Delphi : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Delphi"

    override fun getYear(): Int = 1986

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Imperative, Paradigm.Structured, Paradigm.ObjectOriented)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "{${'$'}APPTYPE CONSOLE}\n", color = secondaryVariantColor)
            appendWithColor(string = "begin\n", color = primaryColor)
            appendWithColor(string = "${tab}Write", color = secondaryColor)
            append("(")
            appendWithColor(string = "'Hello, World!'", color = primaryVariantColor)
            append(");\n")
            appendWithColor(string = "end", color = primaryColor)
            append(".")
        }
    }
}

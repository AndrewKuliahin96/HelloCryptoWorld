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
object Pascal : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Pascal"

    override fun getYear(): Int = 1970

    override fun getParadigms(): List<Paradigm> = listOf(Paradigm.Imperative, Paradigm.Structured)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "begin\n", color = primaryColor)
            appendWithColor(string = "${tab}write", color = secondaryVariantColor)
            append("(")
            appendWithColor(string = "'Hello, World!'", color = primaryVariantColor)
            append(");\n")
            appendWithColor(string = "end", color = primaryColor)
            append(".")
        }
    }
}

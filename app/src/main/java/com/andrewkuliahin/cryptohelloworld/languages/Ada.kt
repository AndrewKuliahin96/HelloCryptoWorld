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
object Ada : ProgrammingLanguage() {

    override fun getTextSize(): TextUnit = 22.sp

    override fun getName(): String = "Ada"

    override fun getYear(): Int = 1980

    override fun getParadigms(): List<Paradigm> =
        listOf(Paradigm.Structured, Paradigm.Procedural, Paradigm.ObjectOriented)

    override fun getAnnotatedHelloWorld(): AnnotatedString {
        return buildAnnotatedString {
            appendWithColor(string = "with ", color = primaryColor)
            appendWithColor(string = "Ada.Text_IO", color = primaryVariantColor)
            append(";\n")
            appendWithColor(string = "use ", color = primaryColor)
            appendWithColor(string = "Ada.Text_IO", color = primaryVariantColor)
            append(";\n\n")
            appendWithColor(string = "procedure", color = primaryColor)
            appendWithColor(string = " Main ", color = secondaryColor)
            appendWithColor(string = "is\n", color = primaryColor)
            appendWithColor(string = "begin\n", color = primaryColor)
            append("${tab}Put_Line (")
            appendWithColor(string = "\"Hello, World!\"", color = secondaryVariantColor)
            append(");\n")
            appendWithColor(string = "end ", color = primaryColor)
            appendWithColor(string = "Main", color = secondaryColor)
            append(";")
        }
    }
}
